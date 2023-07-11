package com.pawka.datecalculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ButtonPanel(buttonSpacing: Dp, viewModel: CalculatorViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        verticalArrangement = Arrangement.spacedBy(buttonSpacing)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            CalculatorButton(
                symbol = "7",
                backgroundColor = MaterialTheme.colorScheme.inverseOnSurface,
                textColor = MaterialTheme.colorScheme.onSecondaryContainer,
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f)
            ) {
                viewModel.onAction(CalculatorAction.Number(7))
            }
            CalculatorButton(
                symbol = "8",
                backgroundColor = MaterialTheme.colorScheme.inverseOnSurface,
                textColor = MaterialTheme.colorScheme.onSecondaryContainer,
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f)
            ) {
                viewModel.onAction(CalculatorAction.Number(8))
            }
            CalculatorButton(
                symbol = "9",
                backgroundColor = MaterialTheme.colorScheme.inverseOnSurface,
                textColor = MaterialTheme.colorScheme.onSecondaryContainer,
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f)
            ) {
                viewModel.onAction(CalculatorAction.Number(9))
            }
            CalculatorButton(
                symbol = "AC",
                backgroundColor = MaterialTheme.colorScheme.tertiaryContainer,
                textColor = MaterialTheme.colorScheme.onTertiaryContainer,
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f)
            ) {
                viewModel.onAction(CalculatorAction.Clear)
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            CalculatorButton(
                symbol = "4",
                backgroundColor = MaterialTheme.colorScheme.inverseOnSurface,
                textColor = MaterialTheme.colorScheme.onSecondaryContainer,
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f)
            ) {
                viewModel.onAction(CalculatorAction.Number(4))
            }
            CalculatorButton(
                symbol = "5",
                backgroundColor = MaterialTheme.colorScheme.inverseOnSurface,
                textColor = MaterialTheme.colorScheme.onSecondaryContainer,
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f)
            ) {
                viewModel.onAction(CalculatorAction.Number(5))
            }
            CalculatorButton(
                symbol = "6",
                backgroundColor = MaterialTheme.colorScheme.inverseOnSurface,
                textColor = MaterialTheme.colorScheme.onSecondaryContainer,
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f)
            ) {
                viewModel.onAction(CalculatorAction.Number(6))
            }
            CalculatorButton(
                symbol = "–",
                backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
                textColor = MaterialTheme.colorScheme.onSecondaryContainer,
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f)
            ) {
                viewModel.onAction(
                    CalculatorAction.Operation(
                        CalculatorOperation.Subtract
                    )
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            CalculatorButton(
                symbol = "1",
                backgroundColor = MaterialTheme.colorScheme.inverseOnSurface,
                textColor = MaterialTheme.colorScheme.onSecondaryContainer,
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f)
            ) {
                viewModel.onAction(CalculatorAction.Number(1))
            }
            CalculatorButton(
                symbol = "2",
                backgroundColor = MaterialTheme.colorScheme.inverseOnSurface,
                textColor = MaterialTheme.colorScheme.onSecondaryContainer,
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f)
            ) {
                viewModel.onAction(CalculatorAction.Number(2))
            }
            CalculatorButton(
                symbol = "3",
                backgroundColor = MaterialTheme.colorScheme.inverseOnSurface,
                textColor = MaterialTheme.colorScheme.onSecondaryContainer,
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f)
            ) {
                viewModel.onAction(CalculatorAction.Number(3))
            }
            CalculatorButton(
                symbol = "+",
                backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
                textColor = MaterialTheme.colorScheme.onSecondaryContainer,
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f)
            ) {
                viewModel.onAction(
                    CalculatorAction.Operation(
                        CalculatorOperation.Add
                    )
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            CalculatorButton(
                symbol = "0",
                backgroundColor = MaterialTheme.colorScheme.inverseOnSurface,
                textColor = MaterialTheme.colorScheme.onSecondaryContainer,
                modifier = Modifier
                    .aspectRatio(2f)
                    .weight(2f)
            ) {
                viewModel.onAction(CalculatorAction.Number(0))
            }
            CalculatorButton(
                symbol = "Del",
                backgroundColor = MaterialTheme.colorScheme.inverseOnSurface,
                textColor = MaterialTheme.colorScheme.onSecondaryContainer,
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f)
            ) {
                viewModel.onAction(CalculatorAction.Delete)
            }
            CalculatorButton(
                symbol = "=",
                backgroundColor = MaterialTheme.colorScheme.primaryContainer,
                textColor = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f)
            ) {
                viewModel.onAction(CalculatorAction.Calculate)
            }
        }
    }
}