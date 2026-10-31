package org.insbaixcamp.fitnessapp.ui.screen

import android.icu.util.Calendar
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.insbaixcamp.fitnessapp.R

@Composable
fun ProfileScreen(
    nom: String,
    email: String,
    dataNaixament: String,
    generes: String,
    pes: Int,
    alçada: Int,
    objectiu: String,
    onEditar: () -> Unit
) {
    val anys = dataNaixament.split("/").getOrNull(2)?.toIntOrNull()
        ?.let { Calendar.getInstance().get(Calendar.YEAR) - it } ?: 0

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Perfil", style = MaterialTheme.typography.headlineMedium)

            IconButton(onClick = onEditar) {
                Icon(
                    painter = painterResource(android.R.drawable.ic_menu_edit),
                    contentDescription = "Editar perfil"
                )
            }
        }

        Column(
            Modifier.fillMaxWidth().padding(top = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
            )
            Text(nom, modifier = Modifier.padding(8.dp))
            Text(email, modifier = Modifier.padding(8.dp))
        }

        Card(modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp)) {
            Row(modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp)) {
                Column(Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painterResource(android.R.drawable.ic_menu_send), null)
                    Text(anys.toString(), modifier = Modifier.padding(8.dp))
                    Text("Edat")
                }
                Column(Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painterResource(android.R.drawable.ic_menu_send), null)
                    Text(generes, modifier = Modifier.padding(8.dp))
                    Text("Genero")
                }
                Column(Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painterResource(android.R.drawable.ic_menu_send), null)
                    Text("$pes kg", modifier = Modifier.padding(8.dp))
                    Text("Peso")
                }
                Column(Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painterResource(android.R.drawable.ic_menu_send), null)
                    Text("$alçada cm", modifier = Modifier.padding(8.dp))
                    Text("Altura")
                }
            }
        }

        Text("Objectius", style = MaterialTheme.typography.titleMedium)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .height(IntrinsicSize.Min),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            OBJECTIUS.forEach { text ->
                Card(
                    modifier = Modifier.weight(1f).fillMaxHeight(),
                    colors = CardDefaults.cardColors(
                        containerColor = if (text == objectiu)
                            MaterialTheme.colorScheme.primaryContainer
                        else MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(painterResource(android.R.drawable.ic_menu_send), null)
                        Text(text, modifier = Modifier.padding(8.dp))
                    }
                }
            }
        }

        Text(
            "Nivell de Activitat",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(top = 8.dp)
        )

        Card(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
            Row(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                Image(painterResource(id = R.drawable.ic_launcher_foreground), null)
                Column {
                    Text("Moderat")
                    Text("Entreno")
                }
            }
        }
    }
}