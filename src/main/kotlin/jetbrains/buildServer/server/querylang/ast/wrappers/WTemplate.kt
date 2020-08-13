package jetbrains.buildServer.server.querylang.ast.wrappers

import jetbrains.buildServer.serverSide.BuildTypeTemplate
import jetbrains.buildServer.util.Option

fun BuildTypeTemplate.wrap() = WTemplate(this)

class WTemplate(
    val stemplate: BuildTypeTemplate
) : FIdContainer,
    FProjectContainer,
    FParentContainer,
    FTriggerContainer,
    FStepContainer,
    FParamContainer,
    FDependencyContainer,
    FOptionContainer
{
    override val id: String
        get() = stemplate.externalId

    override val project: WProject
        get() = stemplate.project.wrap()

    override val parent: WProject?
        get() = stemplate.project.wrap()

    override val ownTriggers: List<WTrigger>
        get() = stemplate.buildTriggersCollection.map { it.wrap() }

    override val triggers: List<WTrigger>
        get() = ownTriggers

    override val ownSteps: List<WStep>
        get() = stemplate.buildRunners.map {it.wrap()}

    override val steps: List<WStep>
        get() = ownSteps

    override fun isEnabled(obj: FEnabledContainer): Boolean {
        if (obj !is WParametersDescriptor) {
            throw IllegalStateException()
        }
        return stemplate.isEnabled(obj.obj.id)
    }

    override val ownParams: Map<String, String>
        get() = stemplate.ownParameters

    override val params: Map<String, String>
        get() = stemplate.parameters

    override val options: Collection<Option<Any>>
        get() = stemplate.options

    override val ownOptions: Collection<Option<Any>>
        get() = stemplate.ownOptions

    override fun getOption(opt: Option<Any>): Any {
        return stemplate.getOption(opt)
    }

    override val dependencies: List<WDependency>
        get() = (stemplate.dependencies.map {it.wrap()} + stemplate.artifactDependencies.map {it.wrap()}).uniteEqual()

    override val ownDependencies: List<WDependency>
        get() = dependencies
}