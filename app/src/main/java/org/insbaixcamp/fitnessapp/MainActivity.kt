package org.insbaixcamp.fitnessapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import org.insbaixcamp.fitnessapp.ui.theme.FitnessAppTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import org.insbaixcamp.fitnessapp.ui.screen.EditProfileScreen
import org.insbaixcamp.fitnessapp.ui.screen.ProfileScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FitnessAppTheme {
                FitnessApp()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FitnessAppTheme {
    }
}

@Composable
fun FitnessApp() {
    var nom by remember { mutableStateOf("Marcos Jalca") }
    var email by remember { mutableStateOf("email@gmail.com") }
    var dataNaixament by remember { mutableStateOf("12/07/1998") }
    var genere by remember { mutableStateOf("Home") }
    var editant by remember { mutableStateOf(false) }
    var pes by remember { mutableIntStateOf(70) }
    var alçada by remember { mutableIntStateOf(175) }
    var objectiu by remember { mutableStateOf("Millorar la salut") }

    if (editant) {
        EditProfileScreen(
            nom = nom,
            email = email,
            dataNaixament = dataNaixament,
            genere = genere,
            pes = pes,
            alçada = alçada,
            objectiu = objectiu,
            onGuardar = { n, e, d, g, p, a, o ->
                nom = n
                email = e
                dataNaixament = d
                genere = g
                pes = p
                alçada = a
                objectiu = o
                editant = false
            },
            onCancelar = { editant = false }
        )
    } else {
        ProfileScreen(
            nom = nom,
            email = email,
            dataNaixament = dataNaixament,
            generes = genere,
            pes = pes,
            alçada = alçada,
            objectiu = objectiu,
            onEditar = { editant = true }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FitnessAppPreview() {
    FitnessAppTheme {
        FitnessApp()
    }
}