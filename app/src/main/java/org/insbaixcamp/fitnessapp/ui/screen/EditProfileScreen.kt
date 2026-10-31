package org.insbaixcamp.fitnessapp.ui.screen

import DropdownTextField
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import org.insbaixcamp.fitnessapp.R
import org.insbaixcamp.fitnessapp.ui.components.OutlinedDatePickerField
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

val OBJECTIUS = listOf("Guanyar massa muscular", "Millorar la salut", "Mantenir el pes")

private val fmt = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    .apply { timeZone = TimeZone.getTimeZone("UTC") }

@Composable
fun EditProfileScreen(
    nom: String,
    email: String,
    dataNaixament: String,
    genere: String,
    pes: Int,
    alçada: Int,
    objectiu: String,
    onGuardar: (String, String, String, String, Int, Int, String) -> Unit,
    onCancelar: () -> Unit,
) {
    var nomEdit by rememberSaveable { mutableStateOf(nom) }
    var emailEdit by rememberSaveable { mutableStateOf(email) }
    var dataMillis by rememberSaveable {
        mutableStateOf<Long?>(runCatching { fmt.parse(dataNaixament)?.time }.getOrNull())
    }
    var pesEdit by rememberSaveable { mutableStateOf(pes.toString()) }
    var alçadaEdit by rememberSaveable { mutableStateOf(alçada.toString()) }
    var objectiuEdit by rememberSaveable { mutableStateOf(objectiu) }

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text("Editar Perfil", style = MaterialTheme.typography.headlineLarge)

        Text("Foto de perfil", fontWeight = FontWeight.Bold)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Foto de perfil",
                modifier = Modifier.size(80.dp)
            )
            Column {
                Button(onClick = { }) { Text("Canviar Foto") }
                Button(onClick = { }) { Text("Eliminar Foto") }
            }
        }

        Text("Dades Personals", fontWeight = FontWeight.Bold)

        OutlinedTextField(
            value = nomEdit,
            onValueChange = { nomEdit = it },
            label = { Text("Nom complet") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = emailEdit,
            onValueChange = { emailEdit = it },
            label = { Text("Correu electrònic") },
            modifier = Modifier.fillMaxWidth()
        )

        DropdownTextField(
            label = "Objectiu",
            opcions = OBJECTIUS,
            valorSeleccionat = objectiuEdit,
            onValorSeleccionat = { objectiuEdit = it },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedDatePickerField(
            label = "Data de naixement",
            selectedDateMillis = dataMillis,
            onDateSelected = { dataMillis = it },
            modifier = Modifier.fillMaxWidth()
        )

        Text("Dades Fisiques", fontWeight = FontWeight.Bold)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                value = alçadaEdit,
                onValueChange = { alçadaEdit = it },
                label = { Text("Alçada") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = pesEdit,
                onValueChange = { pesEdit = it },
                label = { Text("Pes") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f)
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedButton(onClick = onCancelar, modifier = Modifier.weight(1f)) {
                Text("Cancel·lar")
            }
            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    onGuardar(
                        nomEdit,
                        emailEdit,
                        dataMillis?.let { fmt.format(Date(it)) } ?: dataNaixament,
                        genere,
                        pesEdit.toIntOrNull() ?: pes,
                        alçadaEdit.toIntOrNull() ?: alçada,
                        objectiuEdit
                    )
                }
            ) {
                Text("Guardar canvis")
            }
        }
    }
}