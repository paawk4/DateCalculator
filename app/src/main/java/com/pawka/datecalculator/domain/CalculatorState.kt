package com.pawka.datecalculator.domain

import java.time.LocalDate

data class CalculatorState(
    val number1: String = "",
    val number2: String = "",
    val operation: CalculatorOperation? = null,
    val result: LocalDate? = null
)