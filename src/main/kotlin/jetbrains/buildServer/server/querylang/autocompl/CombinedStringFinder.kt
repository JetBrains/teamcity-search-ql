package jetbrains.buildServer.server.querylang.autocompl

class CombinedStringFinder(vararg t: StringFinder) : StringFinder {
    val stringFinders: List<StringFinder>

    init {
        val sfs = mutableListOf<StringFinder>()
        for (sf in t) {
            sfs.add(sf)
        }
        stringFinders = sfs
    }
    override fun completeString(prefix: String, limit: Int): List<String> {
        val res = mutableListOf<String>()
        for (sf in stringFinders) {
            res.addAll(sf.completeString(prefix, limit))
        }
        return res.sortedWith(compareBy({it.length}, {it})).take(limit)
    }
}