package com.pawka.datecalculator.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.pawka.datecalculator.domain.CalculatorAction
import com.pawka.datecalculator.domain.CalculatorOperation
import com.pawka.datecalculator.domain.CalculatorState
import java.time.LocalDate
import java.time.Period

class CalculatorViewModel : ViewModel() {

    var state by mutableStateOf(CalculatorState())

    fun onAction(action: CalculatorAction) {
        when (action) {
            is CalculatorAction.Number -> enterNumber(action.number)
            is CalculatorAction.Delete -> delete()
            is CalculatorAction.Clear -> state = CalculatorState()
            is CalculatorAction.Operation -> enterOperation(action.operation)
            is CalculatorAction.Calculate -> calculate()
        }
    }

    private fun enterOperation(operation: CalculatorOperation) {
        if (state.number1.length == NUMBER_LENGTH)
            state = state.copy(operation = operation)
    }

    private fun calculate() {
        var number1 = state.number1
        var number2 = state.number2

        if (number1.isNotEmpty() && number2.isNotEmpty()) {
            if (number1.toInt() == 0) {
                number1 = "00000000"
            }
            if (number2.toInt() == 0) {
                number2 = "00000000"
            }
            val day1 = number1.substring(0, 2).toInt()
            val month1 = number1.substring(2, 4).toInt()
            val year1 = number1.substring(4, 8).toInt()
            val date1 = LocalDate.of(year1, month1, day1)

            val day2 = number2.substring(0, 2).toInt()
            val month2 = number2.substring(2, 4).toInt()
            val year2 = number2.substring(4, 8).toInt()
            val date2 = Period.of(year2, month2, day2)
            val result = when (state.operation) {
                is CalculatorOperation.Add -> date1.plus(date2)
                is CalculatorOperation.Subtract -> date1.minus(date2)
                null -> return
            }
            state = state.copy(
                result = result
            )
        }
    }

    private fun delete() {
        when {
            state.number2.isNotBlank() -> state = state.copy(
                number2 = state.number2.dropLast(1)
            )

            state.operation != null -> state = state.copy(
                operation = null
            )

            state.number1.isNotBlank() -> state = state.copy(
                number1 = state.number1.dropLast(1)
            )
        }
    }

    private fun enterNumber(number: Int) {
        if (state.operation == null) {
            if (state.number1.length >= NUMBER_LENGTH
            ) {
                return
            }
            state = state.copy(
                number1 = state.number1 + number
            )
            return
        }
        if (state.number2.length >= NUMBER_LENGTH) {
            return
        }
        state = state.copy(
            number2 = state.number2 + number
        )
    }

    companion object {
        private const val NUMBER_LENGTH = 8
    }

}