package jetbrains.buildServer.server.querylang.ast

interface Filter : Named, Printable

interface ParameterHolderFilterType : Filter

interface ProjectFilterType: Filter

interface VcsRootFilterType : Filter, VcsRootEntryFilter

interface TemplateFilterType : Filter

interface BuildConfFilterType : Filter