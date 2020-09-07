package jetbrains.buildServer.server.querylang.ui.objects

import jetbrains.buildServer.server.querylang.ast.wrappers.FIdContainer
import jetbrains.buildServer.server.querylang.ast.wrappers.FNameContainer
import jetbrains.buildServer.server.querylang.ast.wrappers.FProjectContainer
import jetbrains.buildServer.server.querylang.ast.wrappers.WProject

abstract class TeamCityObjectResult<T>
    where T : FIdContainer,
          T : FNameContainer,
          T : FProjectContainer
{
    val externalId: String
    val name: String
    val project: WProject?

    constructor(externalId_: String, name_: String, project_: WProject?) {
        externalId = externalId_
        name = name_
        project = project_
    }

    constructor(obj: T) {
        externalId = obj.id
        name = obj.name
        project = obj.project
    }
}