package com.moneyforward.challenge

fun main() {
    moneyForwardChallenge()
}

fun moneyForwardChallenge() {
    try {
        print("Enter a user ID (integer): ")
        val userId = readIntegerOrElseThrow()

        val service = UserService()
        val userDetails = service.getUserDetails(userId)
        val userAccounts = service.getAllAccountsForUser(userId)

        calculateAndPrintOutput(userDetails, userAccounts)
    } catch (e: Exception) {
        println("Something went wrong: " + e.message)
    }
}

fun readIntegerOrElseThrow(): Int {
    return readlnOrNull()
        ?.toIntOrNull()
        ?: throw IllegalArgumentException("Invalid input, please provide an integer")
}

/**
 * Calculates and prints the desired output for the assignment.
 */
fun calculateAndPrintOutput(userDetails: UserResponse, userAccounts: UserAccountsResponse) {
    println()
    println("User name:")
    println(userDetails.getName())

    println()
    println("List of registered financial institutions:")
    println(userAccounts.getListOfAccounts())

    println()
    println("Total balance:")
    println(userAccounts.getTotalBalance())
}
