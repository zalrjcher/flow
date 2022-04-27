package com.zoorm.flow.listeners;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManagerListener;
import com.zoorm.flow.palette.impl.PaletteToolWindowManager;
import com.zoorm.flow.palette.impl.PaletteWindow;
import com.zoorm.flow.services.MyProjectService;
import org.jetbrains.annotations.NotNull;

/**
 * @author lenovo
 * @title: MyProjectManagerListener
 * @projectName flow
 * @description: TODO
 * @date 2022/4/2714:54
 */
public class MyProjectManagerListener implements ProjectManagerListener {
    @Override
    public void projectOpened(@NotNull Project project) {
        MyProjectService service =project.getService(MyProjectService.class);
        service.init(project);
        PaletteWindow window = PaletteToolWindowManager.getInstance1(project);
        System.out.println(window);
    }
}
