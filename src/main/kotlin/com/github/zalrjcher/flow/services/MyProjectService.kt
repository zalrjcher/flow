package com.github.zalrjcher.flow.services

import com.intellij.openapi.project.Project
import com.github.zalrjcher.flow.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
