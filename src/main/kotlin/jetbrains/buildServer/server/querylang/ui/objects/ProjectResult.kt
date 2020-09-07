package jetbrains.buildServer.server.querylang.ui.objects

import jetbrains.buildServer.server.querylang.ast.wrappers.WProject

class ProjectResult(proj: WProject) : TeamCityObjectResult<WProject>(proj.id, proj.name, proj.parent)