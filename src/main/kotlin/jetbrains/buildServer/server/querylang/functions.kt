package jetbrains.buildServer.server.querylang

import jetbrains.buildServer.server.querylang.ast.FilterTypeRegistration

internal fun String.toIdentOrString(): String {
    if (this.all {it.isLetter() || it.isDigit() || it in "_.-"} && !FilterTypeRegistration.isKeyWord(this)) {
        return this
    } else {
        return "\"" + this.escapeQuotes() + "\""
    }
}

internal fun String.fromIdentOrString(): String {
    if (this.length <= 1) {
        return this
    }

    var res = this

    if (this.first() == '"') {
        res = res.drop(1)
    }

    if (this.last() == '"') {
        res = res.dropLast(1)
    }

    return res.removeEscapeQuotes()
}

internal fun String.removeEscapeQuotes(): String {
    return this.replace("\"\"", "\"")
}

internal fun String.escapeQuotes(): String {
    return this.replace("\"", "\"\"")
}