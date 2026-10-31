package org.insbaixcamp.fitnessapp

import junit.framework.TestCase.assertEquals
import org.insbaixcamp.fitnessapp.utils.CalculadoraIMC
import org.junit.Test
import java.nio.DoubleBuffer

class CalculadoraIMCUnitTest

{
    @Test
    fun testCalculadroImc(){
        var pes: Double = 60.0
        var alçada: Int = 180
        var imc = CalculadoraIMC.calcularIMC(pes, alçada)
        assertEquals(24.22, imc, 0.02)
    }
}