package jetbrains.buildServer.server.querylang.filter

class ObjectFilter<T>(val condition: (obj: T) -> Boolean) {
    fun accepts(obj: T?): Boolean = obj?.let {condition(it)} ?: false
}