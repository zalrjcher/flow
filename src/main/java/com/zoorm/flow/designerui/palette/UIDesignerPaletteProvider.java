// Copyright 2000-2021 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package com.zoorm.flow.designerui.palette;


import com.intellij.openapi.fileTypes.FileTypeRegistry;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.zoorm.flow.common.GuiFlowFileType;
import com.zoorm.flow.palette.PaletteGroup;
import com.zoorm.flow.palette.PaletteItemProvider;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * 生成palette
 */

public final class UIDesignerPaletteProvider implements PaletteItemProvider {
  @NonNls private static final String PROPERTY_GROUPS = "groups";

  private final Project myProject;
  private final PropertyChangeSupport myPropertyChangeSupport = new PropertyChangeSupport(this);
  private Palette.Listener myListener;

  public UIDesignerPaletteProvider(final Project project) {
    myProject = project;
  }

  void fireGroupsChanged() {
    myPropertyChangeSupport.firePropertyChange(PROPERTY_GROUPS, null, null);
  }

  @Override
  public PaletteGroup[] getActiveGroups(VirtualFile vFile) {
    //判断是否是.form 文件
    if (FileTypeRegistry.getInstance().isFileOfType(vFile, GuiFlowFileType.INSTANCE)) {
      Palette palette = Palette.getInstance(myProject);
      if (myListener == null) {
        myListener = new Palette.Listener() {
          @Override
          public void groupsChanged(@NotNull Palette palette) {
            fireGroupsChanged();
          }
        };
        palette.addListener(myListener);
      }
      return null ;
//      return palette.getToolWindowGroups();
    }
    return PaletteGroup.EMPTY_ARRAY;
  }

  @Override
  public void addListener(PropertyChangeListener listener) {
    myPropertyChangeSupport.addPropertyChangeListener(listener);
  }

  @Override
  public void removeListener(PropertyChangeListener listener) {
    myPropertyChangeSupport.removePropertyChangeListener(listener);
  }
}
