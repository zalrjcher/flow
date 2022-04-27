// Copyright 2000-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.zoorm.flow.uiDesigner;

import com.intellij.designer.DesignerEditorPanelFacade;
import com.intellij.designer.LightToolWindowManager;
import com.intellij.designer.ToggleEditorModeAction;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindowAnchor;
//import com.intellij.uiDesigner.editor.UIFormEditor;
import com.zoorm.flow.palette.impl.PaletteToolWindowManager;
import org.jetbrains.annotations.Nullable;

/**
 * @author Alexander Lobas
 */
public abstract class AbstractToolWindowManager extends LightToolWindowManager {
  protected AbstractToolWindowManager(Project project) {
    super(project);
  }

  @Nullable
  @Override
  protected DesignerEditorPanelFacade getDesigner(FileEditor editor) {
//    if (editor instanceof UIFormEditor) {
//      UIFormEditor formEditor = (UIFormEditor)editor;
//      return formEditor.getEditor();
//    }
    return null;
  }

  @Override
  protected ToggleEditorModeAction createToggleAction(ToolWindowAnchor anchor) {
    return new ToggleEditorModeAction(this, myProject, anchor) {
      @Override
      protected LightToolWindowManager getOppositeManager() {
//        AbstractToolWindowManager designerManager = DesignerToolWindowManager.getInstance(myProject);
        AbstractToolWindowManager paletteManager = PaletteToolWindowManager.getInstance(myProject);
//         myManager == designerManager ? paletteManager : designerManager;
        return paletteManager;
      }
    };
  }
}