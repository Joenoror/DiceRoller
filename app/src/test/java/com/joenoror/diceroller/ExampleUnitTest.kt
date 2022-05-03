package com.joenoror.diceroller

import org.junit.Assert.assertTrue
import org.junit.Test

class ExampleUnitTest {
    @Test
    fun generates_Number(){
        val dice = Dice(6)
        val rollResult = dice.roll()
        assertTrue("The value of the dice wasn't between 1 and 6", rollResult in 1..6)
    }
}