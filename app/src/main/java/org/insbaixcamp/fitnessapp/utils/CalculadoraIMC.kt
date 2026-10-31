
package org.insbaixcamp.fitnessapp.utils

import kotlin.math.round

class CalculadoraIMC {

    companion object {

        fun calcularIMC(pes: Double, alçada: Int): Double {
            val alturaMetres = alçada.toDouble() / 100

            val imc = pes / (alturaMetres * alturaMetres)

            return round(imc * 100) / 100.0
        }
    }
}
