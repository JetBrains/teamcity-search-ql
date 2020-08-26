package jetbrains.buildServer.server.querylang.autocompl

internal fun String.escape1(): String {
    if (this == "") {
        return "\"\""
    }
    val str = this.replace("\"", "\"\"")

    /*
    if (FilterTypeRegistration.isKeyWord(str)) {
        return "\"" + str + "\""
    }
     */

    if (str.all {it.isLetter() || it.isDigit() || it in "_.-"}) {
        return str
    }
    else {
        return "\"$str\""
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