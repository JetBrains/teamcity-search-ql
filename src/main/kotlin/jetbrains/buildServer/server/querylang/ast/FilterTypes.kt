package jetbrains.buildServer.server.querylang.ast

interface ParameterHolderFilterType : Filter
interface ParHolderComplexFilter : ConditionContainer<ParameterHolderFilterType>

interface ProjectFilterType: Filter
interface ProjectComplexFilter : ConditionContainer<ProjectFilterType>

interface VcsRootFilterType : Filter, VcsRootEntryFilter
interface VcsRootComplexFilter : ConditionContainer<VcsRootFilterType>

interface TemplateFilterType : Filter
interface TemplateComplexFilter : ConditionContainer<TemplateFilterType>

interface BuildConfFilterType : Filter, DependencyFilterType
interface BuildConfComplexFilter : ConditionContainer<BuildConfFilterType>

interface VcsRootEntryFilter : Filter
interface VcsRootEntryComplexFilter : ConditionContainer<VcsRootEntryFilter>


interface DependencyFilterType : Filter
interface DependencyComplexFilter : ConditionContainer<DependencyFilterType>

interface SnapshotDepFilterType : Filter
interface SnapshotDepComplexFilter : ConditionContainer<SnapshotDepFilterType>