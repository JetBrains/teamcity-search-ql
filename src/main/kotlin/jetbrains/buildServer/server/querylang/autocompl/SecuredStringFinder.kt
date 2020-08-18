package jetbrains.buildServer.server.querylang.autocompl

import jetbrains.buildServer.serverSide.auth.AuthUtil
import jetbrains.buildServer.serverSide.auth.Permission

abstract class SecuredStringFinder {
    fun completeString(prefix: String, limit: Int): List<String> {
        if (systemAdminOnly) {
            val authHolder = compl.securityContext.authorityHolder
            if (!AuthUtil.hasGlobalPermission(authHolder, Permission.CHANGE_SERVER_SETTINGS)) {
                return emptyList()
            }
        }
        return completeStringUnsafe(prefix, limit)
    }

    protected abstract fun completeStringUnsafe(prefix: String, limit: Int): List<String>

    abstract val compl: CompletionManager
    abstract val systemAdminOnly: Boolean
}