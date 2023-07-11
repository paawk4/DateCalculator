package com.pawka.datecalculator

import java.time.LocalDate
import java.time.Period
import java.util.Date

data class CalculatorState(
    val number1: String = "20042023",
    val number2: String = "",
    val operation: CalculatorOperation? = null
)