package jetbrains.buildServer.server.querylang.parser

import jetbrains.buildServer.server.querylang.ast.*

object MainQueryVisitor : QLangGrammarBaseVisitor<MainQuery>() {

    override fun visitStart(ctx: QLangGrammarParser.StartContext?): MainQuery {
        return ctx!!.find().accept(this)
    }

    override fun visitFproject(ctx: QLangGrammarParser.FprojectContext?): MainQuery {
        return FindProject(
                ctx!!.conditionInSubproject().accept(projectConditionVisitor)
        )
    }

    override fun visitFbuildConf(ctx: QLangGrammarParser.FbuildConfContext?): MainQuery {
        return FindBuildConf(
                ctx!!.conditionInSubproject().accept(buildConfConditionVisitor)
        )
    }

    override fun visitFtemplate(ctx: QLangGrammarParser.FtemplateContext?): MainQuery {
        return FindTemplate(
                ctx!!.conditionInSubproject().accept(tempConditionVisitor)
        )
    }

    override fun visitFbuildConfOrTemp(ctx: QLangGrammarParser.FbuildConfOrTempContext?): MainQuery {
        return FindBuildConfOrTemplate(
                ctx!!.conditionInSubproject().accept(buildConfOrTempConditionVisitor)
        )
    }

    override fun visitFvcsRoot(ctx: QLangGrammarParser.FvcsRootContext?): MainQuery {
        return FindVcsRoot(
                ctx!!.conditionInSubproject().accept(vcsRootConditionVisitor)
        )
    }
}