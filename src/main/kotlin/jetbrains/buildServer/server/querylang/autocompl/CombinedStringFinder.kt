package jetbrains.buildServer.server.querylang.autocompl

class CombinedStringFinder(
    override val compl: CompletionManager,
    override val systemAdminOnly: Boolean,
    vararg t: SecuredStringFinder
) : SecuredStringFinder() {
    val stringFinders: List<SecuredStringFinder>

    init {
        val sfs = mutableListOf<SecuredStringFinder>()
        for (sf in t) {
            sfs.add(sf)
        }
        stringFinders = sfs
    }
    override fun completeStringUnsafe(prefix: String, limit: Int): List<String> {
        val res = mutableListOf<String>()
        for (sf in stringFinders) {
            res.addAll(sf.completeString(prefix, limit))
        }
        return res.sortedWith(compareBy({it.length}, {it})).take(limit)
    }
}