package com.pawka.datecalculator.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pawka.datecalculator.ui.theme.DateCalculatorTheme
import com.pawka.datecalculator.ui.theme.Shapes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DateCalculatorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel = viewModel<CalculatorViewModel>()
                    val state = viewModel.state
                    val buttonSpacing = 8.dp
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(buttonSpacing)
                    ) {
                        Card(
                            modifier = Modifier
                                .aspectRatio(1.2f),
                            shape = Shapes.extraLarge
                        ) {
                            Column(
                                Modifier
                                    .fillMaxSize()
                                    .padding(25.dp),
                                verticalArrangement = Arrangement.SpaceBetween,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                DateTextField(state.number1)
                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    text = state.operation?.symbol ?: "",
                                    fontSize = 42.sp,
                                    textAlign = TextAlign.Start
                                )
                                DateTextField(state.number2)
                                val result = if (state.result != null) {
                                    "${state.result.dayOfMonth}/${state.result.monthValue}/${state.result.year}"
                                } else ""

                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    text = result,
                                    fontSize = 42.sp,
                                    textAlign = TextAlign.End
                                )
                            }
                        }
                        ButtonPanel(buttonSpacing, viewModel)
                    }
                }
            }

        }
    }
}
