package jetbrains.buildServer.server.querylang.ast

interface TempFilter : Filter

interface BuildConfFilter : Filter

interface BcOrTempFilter : TempFilter, BuildConfFilter
