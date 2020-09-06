package jetbrains.buildServer.server.querylang

import java.io.FileNotFoundException

internal fun String.toIdentOrString(): String {
    //was ... && !FilterTypeRegistration.isKeyWord(this)
    if (this.all {it.isLetter() || it.isDigit() || it in "_.-"}) {
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

internal fun readFromResources(filename: String): String {
    return Thread.currentThread().contextClassLoader.getResourceAsStream(filename)?.reader()?.readText()
        ?: throw FileNotFoundException("Couldn't read file $filename from resources")
}