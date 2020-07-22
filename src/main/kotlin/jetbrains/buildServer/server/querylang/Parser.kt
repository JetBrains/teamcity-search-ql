package jetbrains.buildServer.server.querylang

import jetbrains.buildServer.server.querylang.parser.QueryParser

fun main() {
    val parser = QueryParser()
    while (true) println(parser.parse(readLine()!!))
}