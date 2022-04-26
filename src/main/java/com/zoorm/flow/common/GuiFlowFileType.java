package com.zoorm.flow.common;

import com.intellij.ide.IdeBundle;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.openapi.util.NlsSafe;
import com.intellij.openapi.vfs.CharsetToolkit;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.PlatformIcons;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * @author lenovo
 * @title: GuiFlowFileType
 * @projectName flow
 * @description: TODO
 * @date 2022/4/2616:29
 */

/**
 * 定义.flow 文件
 */
public class GuiFlowFileType implements FileType {
    private final  static String FILETYPE_NAME="ZOROM_FLOW_FILE";
    @NonNls public static final String DEFAULT_EXTENSION = "flow";
    @NonNls public static final String DOT_DEFAULT_EXTENSION = "." + DEFAULT_EXTENSION;

    public static final GuiFlowFileType INSTANCE = new GuiFlowFileType();

    private GuiFlowFileType() {
    }

    @Override
    @NotNull
    public String getName() {
        return FILETYPE_NAME;
    }

    @Override
    @NotNull
    public String getDescription() {
        return IdeBundle.message("filetype.gui.designer.flow.description");
    }

    @Nls
    @Override
    public @NotNull String getDisplayName() {
        return IdeBundle.message("filetype.gui.designer.flow.display.name");
    }

    @Override
    @NotNull
    public String getDefaultExtension() {
        return DEFAULT_EXTENSION;
    }

    @Override
    public Icon getIcon() {
        return PlatformIcons.UI_FORM_ICON;
    }

    @Override
    public boolean isBinary() {
        return false;
    }

    @Override
    public String getCharset(@NotNull VirtualFile file, final byte @NotNull [] content) {
        return CharsetToolkit.UTF8;
    }
}
