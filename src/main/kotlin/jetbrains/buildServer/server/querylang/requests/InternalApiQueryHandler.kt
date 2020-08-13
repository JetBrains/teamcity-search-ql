package jetbrains.buildServer.server.querylang.requests

import jetbrains.buildServer.server.querylang.ast.*
import jetbrains.buildServer.serverSide.ProjectManager

class InternalApiQueryHandler(
        val projectManager: ProjectManager
) : QueryHandler {
    override fun makeRequest(mainQuery: MainQuery): QueryResult {
        return mainQuery.eval()
    }
}