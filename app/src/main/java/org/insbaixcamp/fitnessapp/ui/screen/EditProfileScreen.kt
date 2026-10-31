package org.insbaixcamp.fitnessapp.ui.screen

import DropdownTextField
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Height
import androidx.compose.material.icons.outlined.MonitorWeight
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
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
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp, vertical = 24.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        // Header
        Column(modifier = Modifier.padding(bottom = 4.dp)) {
            Text(
                text = "Editar Perfil",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
            Text(
                text = "Actualitza la teva informació personal i física",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        // Photo Card
        ElevatedCard(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.elevatedCardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(76.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primaryContainer),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Foto de perfil",
                        tint = MaterialTheme.colorScheme.onPrimaryContainer,
                        modifier = Modifier.size(46.dp)
                    )
                }

                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    FilledTonalButton(
                        onClick = { },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text("Canviar Foto", fontWeight = FontWeight.Medium)
                    }
                    OutlinedButton(
                        onClick = { },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text("Eliminar Foto", fontWeight = FontWeight.Medium)
                    }
                }
            }
        }

        // Section: Dades Personals
        Text(
            text = "Dades Personals",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        OutlinedTextField(
            value = nomEdit,
            onValueChange = { nomEdit = it },
            label = { Text("Nom complet") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Person,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
            },
            shape = RoundedCornerShape(14.dp),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = emailEdit,
            onValueChange = { emailEdit = it },
            label = { Text("Correu electrònic") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Email,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
            },
            shape = RoundedCornerShape(14.dp),
            singleLine = true,
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

        // Section: Dades Físiques
        Text(
            text = "Dades Físiques",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(top = 4.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(
                value = alçadaEdit,
                onValueChange = { alçadaEdit = it },
                label = { Text("Alçada (cm)") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Height,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                shape = RoundedCornerShape(14.dp),
                singleLine = true,
                modifier = Modifier.weight(1f)
            )

            OutlinedTextField(
                value = pesEdit,
                onValueChange = { pesEdit = it },
                label = { Text("Pes (kg)") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.MonitorWeight,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                shape = RoundedCornerShape(14.dp),
                singleLine = true,
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Action Buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedButton(
                onClick = onCancelar,
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp),
                shape = RoundedCornerShape(14.dp)
            ) {
                Text(
                    text = "Cancel·lar",
                    fontWeight = FontWeight.SemiBold
                )
            }

            Button(
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
                },
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp),
                shape = RoundedCornerShape(14.dp),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 2.dp)
            ) {
                Text(
                    text = "Guardar",
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}