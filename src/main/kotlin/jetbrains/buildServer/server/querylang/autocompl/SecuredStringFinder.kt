package jetbrains.buildServer.server.querylang.autocompl

import jetbrains.buildServer.serverSide.auth.AuthUtil
import jetbrains.buildServer.serverSide.auth.Permission
import jetbrains.buildServer.serverSide.auth.SecurityContext
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicLong

abstract class SecuredStringFinder {
    fun completeString(prefix: String, limit: Int): List<String> {
        if (disabled.get()) {
            return emptyList()
        }
        if (systemAdminOnly) {
            val authHolder = securityContext.authorityHolder
            if (!AuthUtil.hasGlobalPermission(authHolder, Permission.CHANGE_SERVER_SETTINGS)) {
                return emptyList()
            }
        }
        return completeStringUnsafe(prefix, limit)
    }

    protected abstract fun completeStringUnsafe(prefix: String, limit: Int): List<String>

    abstract fun clear()

    abstract val securityContext: SecurityContext
    abstract val systemAdminOnly: Boolean
    abstract var disabled: AtomicBoolean

    open val nodesTotal: Long = 0
    open val symbolsTotal: Long = 0
}