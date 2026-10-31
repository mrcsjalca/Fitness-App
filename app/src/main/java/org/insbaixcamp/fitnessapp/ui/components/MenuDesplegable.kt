package org.insbaixcamp.fitnessapp.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuDesplegable(){
    val opcions = listOf(
        "Perdre pes",
        "Guanyar massa muscular",
        "Manteniment"
    )

    var desplegat by remember {mutableStateOf(false)}
    var seleccionat by rememberSaveable {mutableStateOf("")}

    ExposedDropdownMenuBox(
        expanded = desplegat,
        onExpandedChange = {
            desplegat = it
        }
    ) {
        OutlinedTextField(
            value = seleccionat,
            onValueChange = {},
            readOnly = true,
            label = { Text("Objectiu") },
            placeholder = { Text("Selecciona un objectiu")},
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = desplegat
                )
            },
            modifier = Modifier
                .menuAnchor(
                    ExposedDropdownMenuAnchorType.PrimaryNotEditable
                )
                .fillMaxWidth()
        )
    }


    ExposedDropdownMenu(
        expanded = desplegat,
        onDismissRequest = {
            desplegat = false
        }
    ) {
        opcions.forEach { opcio ->

            DropdownMenuItem(
                text = { Text(opcio) },
                onClick = {
                    seleccionat = opcio
                    desplegat = false
                }
            )
        }
    }
}

@Composable
fun ExposedDropdownMenu(
    expanded: Boolean,
    onDismissRequest: () -> Unit,
    content: @Composable () -> Unit
) {
    TODO("Not yet implemented")
}


