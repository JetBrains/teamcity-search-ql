package jetbrains.buildServer.server.querylang.parser

import org.antlr.v4.runtime.Token
import java.lang.Exception

class ParsingException(override val message: String) : Exception(message)