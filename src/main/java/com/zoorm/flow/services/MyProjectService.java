package com.zoorm.flow.services;

import com.intellij.openapi.project.Project;

/**
 * @author lenovo
 * @title: MyProjectService
 * @projectName flow
 * @description: TODO
 * @date 2022/4/2714:51
 */
public class MyProjectService {
    public  MyProjectService(Project project){
        System.out.println(project.getName());
    }
    public void init(Project project){
        System.out.println(project.getName()+"aaaaaaaaaaaaaa");
    }
}
