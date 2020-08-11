package jetbrains.buildServer.server.querylang

import jetbrains.buildServer.serverSide.ProjectManager

class MyProjectManager(val projectManager: ProjectManager): ProjectManager by projectManager

lateinit var myProjectManager: MyProjectManager

class MyProjectManagerInit(val projectManager: ProjectManager) {
    init {
        myProjectManager = MyProjectManager(projectManager)
    }
}

