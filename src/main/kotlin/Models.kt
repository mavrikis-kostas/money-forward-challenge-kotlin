package com.moneyforward.challenge

/**
 * API response model for the users endpoint
 */
data class UserResponse(
    val attributes: User
)

data class User(
    val id: Int,
    val name: String,
    val accountIds: Collection<Int>,
)

/**
 * API response model for the accounts endpoint
 */
typealias UserAccountsResponse = List<UserAccountWrapper>

data class UserAccountWrapper(
    val attributes: UserAccount
)

data class UserAccount(
    val id: Int,
    val userId: Int,
    val name: String,
    val balance: Long,
) {
    override fun toString(): String {
        return """
            ID: $id
            User ID: $userId
            Name: $name
            Balance: $balance
        """.trimIndent()
    }
}
