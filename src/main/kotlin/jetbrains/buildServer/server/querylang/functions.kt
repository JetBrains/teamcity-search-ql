package jetbrains.buildServer.server.querylang

internal fun String.toIdentOrString(): String {
    if (this.all {it.isLetter() || it.isDigit() || it in "_.-"}) {
        return this
    } else {
        return "\"" + this + "\""
    }
}