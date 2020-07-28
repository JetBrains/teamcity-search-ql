package jetbrains.buildServer.server.querylang.autocompl

internal fun String.escape(): String {
    val startsWithQuote = this.startsWith("\"")
    if (this.all {it.isLetter() || it.isDigit() || it in "_.-"}) {
        if (startsWithQuote) return this.drop(1)
        return this
    }
    else {
        if (startsWithQuote) return this + "\""
        return "\"this\""
    }
}

internal fun String.removeQuotationMarks(): String {
    var res = this
    if (res.startsWith('\"')) {
        res = res.drop(1)
    }
    if (res.endsWith('\"')) {
        res = res.dropLast(1)
    }
    return res
}