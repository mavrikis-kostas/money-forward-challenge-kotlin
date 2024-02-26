package com.moneyforward.challenge

// Question 1
fun UserResponse.getName(): String = attributes.name

// Question 2
fun UserAccountsResponse.getListOfAccounts(): String =
    this.joinToString("\n\n") { it.attributes.toString() }

// Question 3
fun UserAccountsResponse.getTotalBalance(): Long =
    this.sumOf { it.attributes.balance }
