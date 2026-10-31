
package org.insbaixcamp.fitnessapp.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.insbaixcamp.fitnessapp.utils.CalculadoraIMC
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


@Composable
fun WeightTrakingScreen(
    pes: Double,
    pesObjectiu: Double,
    alçada: Int
) {
    var pesNou by remember { mutableStateOf(pes.toString()) }

    var listPes = mutableListOf<Double>()

    val imc = CalculadoraIMC.calcularIMC(pes, alçada)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Card(
                modifier = Modifier.weight(1f),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 4.dp
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Pes actual")
                    Text("$pes kg")
                }
            }

            Card(
                modifier = Modifier.weight(1f),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 4.dp
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Pes objectiu")
                    Text("$pesObjectiu kg")
                }
            }

            Card(
                modifier = Modifier.weight(1f),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 4.dp
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("IMC")
                    Text("$imc")
                }
            }
        }

        Text("Registrar un nou pes")



        OutlinedTextField(
            label = { Text("Nou pes (kg)") },
            value = pesNou,
            onValueChange = { pesNou = it },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                // Aquí añadiremos la acción para registrar el peso
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Registrar pes")
        }

        Text("Evolucio del pes")



    }
}

@Preview(showBackground = true)
@Composable
fun WeightTrakingScreenPreview() {
    WeightTrakingScreen(
        pes = 70.0,
        pesObjectiu = 65.0,
        alçada = 170
    )
}
