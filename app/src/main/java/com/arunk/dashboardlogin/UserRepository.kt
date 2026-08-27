package com.arunk.dashboardlogin

data class UserAccount(
    val username: String,
    val password: String
)

/**
 * Simple in-memory store for registered accounts.
 * Note: this resets when the app process is killed, since there's no
 * persistent storage (Room/DataStore) wired up yet. Same limitation the
 * student data list in Data.kt already has.
 */
object UserRepository {
    private val users = mutableListOf<UserAccount>()

    fun register(username: String, password: String): Boolean {
        val exists = users.any { it.username.equals(username, ignoreCase = true) }
        if (exists) return false

        users.add(UserAccount(username, password))
        return true
    }

    fun authenticate(username: String, password: String): Boolean {
        return users.any {
            it.username.equals(username, ignoreCase = true) && it.password == password
        }
    }
}