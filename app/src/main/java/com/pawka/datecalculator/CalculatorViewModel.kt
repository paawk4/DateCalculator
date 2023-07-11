package com.pawka.datecalculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.time.LocalDate
import kotlin.time.Duration.Companion.days

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
        state = state.copy(operation = operation)
        //ДОБАВИТЬ ПРОВЕРКУ НА ПЕРВОЕ ЧИСЛО
    }

    private fun calculate() {
//        val number1 = state.number1.toDoubleOrNull()
//        val number2 = state.number2.toDoubleOrNull()
//        if (number1 != null && number2 != null) {
//            val result = when (state.operation) {
//                is CalculatorOperation.Add -> number1 + number2
//                is CalculatorOperation.Subtract -> number1 - number2
//                null -> return
//            }
//            state = state.copy(
//                number1 = result.toString().take(15),
//                number2 = "",
//                operation = null
//            )
//        }
    }

    private fun delete() {
//        when {
//            state.number2.isNotBlank() -> state = state.copy(
//                number2 = state.number2.dropLast(1)
//            )
//
//            state.operation != null -> state = state.copy(
//                operation = null
//            )
//
//            state.number1.isNotBlank() -> state = state.copy(
//                number1 = state.number1.dropLast(1)
//            )
//        }
    }

    private fun enterNumber(number: Int) {
        if (state.operation == null) {
            if (state.number1.length != NUMBER_LENGTH
            ) {
                return
            }
            state = state.copy(
                number1 = state.number1 + number
            )
            return
        }
        if (state.number2.length > NUMBER_LENGTH) {
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