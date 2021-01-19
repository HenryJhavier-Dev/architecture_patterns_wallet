package com.henryjhavierdev.architecturepatternswallet.model

data class Loan(
        val typeName: String,
        val totalPaidAmount: Double,
        val paidAmount: Double,
        val loanNumber: String
)