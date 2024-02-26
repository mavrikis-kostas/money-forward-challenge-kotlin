package com.moneyforward.challenge

/**
 * Retrieves user and account details from the Sample Accounts API.
 */
class UserService {
    /**
     * Retrieves the user details for a specific user ID.
     * @throws Exception if the request was unsuccessful
     */
    fun getUserDetails(userId: Int): UserResponse {
        val uri = USERS_API.replace("{id}", userId.toString())
        return HttpUtils.simpleGetRequest<UserResponse>(uri)
    }

    /**
     * Retrieves all the account details for a specific user ID.
     * @throws Exception if the request was unsuccessful
     */
    fun getAllAccountsForUser(userId: Int): UserAccountsResponse {
        val uri = USER_ACCOUNTS_API.replace("{id}", userId.toString())
        return HttpUtils.simpleGetRequest<UserAccountsResponse>(uri)
    }

    companion object {
        private const val SAMPLE_ACCOUNTS_HOSTNAME = "https://sample-accounts-api.herokuapp.com"

        private const val USERS_API = "$SAMPLE_ACCOUNTS_HOSTNAME/users/{id}"
        private const val USER_ACCOUNTS_API = "$SAMPLE_ACCOUNTS_HOSTNAME/users/{id}/accounts"
    }
}
