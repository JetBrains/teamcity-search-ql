package jetbrains.buildServer.server.querylang.ast

import jetbrains.buildServer.serverSide.BuildTypeTemplate
import jetbrains.buildServer.serverSide.SBuildType
import jetbrains.buildServer.serverSide.SProject
import jetbrains.buildServer.vcs.SVcsRoot

sealed class TopLevelQuery<T : Filter, S : Any> : Named, ConditionContainer<T, S> {
    fun wrap(): MainQuery {
        return FindMultipleTypes(listOf(this))
    }

    abstract override val condition: ConditionAST<T>
}

data class FindProject(override val condition: ConditionAST<ProjectFilterType>) : TopLevelQuery<ProjectFilterType, SProject>(),
    ProjectConditionContainer {
    companion object : Names("project")
    override val names = FindProject.names
}

data class FindBuildConf(override val condition: ConditionAST<BuildConfFilterType>) : TopLevelQuery<BuildConfFilterType, SBuildType>(), BuildConfConditionContainer {
    companion object : Names("configuration", "buildConfiguration")
    override val names = FindBuildConf.names
}

data class FindTemplate(override val condition: ConditionAST<TemplateFilterType>) : TopLevelQuery<TemplateFilterType, BuildTypeTemplate>(), TemplateConditionContainer {
    companion object : Names("template")
    override val names = FindTemplate.names
}

data class FindVcsRoot(override val condition: ConditionAST<VcsRootFilterType>) : TopLevelQuery<VcsRootFilterType, SVcsRoot>(), VcsRootConditionContainer {
    companion object : Names("vcsRoot")
    override val names = FindVcsRoot.names
}