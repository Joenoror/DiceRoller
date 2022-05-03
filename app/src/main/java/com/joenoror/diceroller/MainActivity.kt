package com.joenoror.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Make the button interactable
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            //You can unify both previous sentences as -->
            //Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
            //Preparo el texto a mostrar, en este caso mediante la función rollDice
            rollDice()
        }

    }

    private fun rollDice() {
        //Create a dice object
        val dice = Dice(6)
        val dice2 = Dice(10)
        val textView:TextView = findViewById(R.id.textView)
        val textView2:TextView = findViewById(R.id.textView2)
        showTheScreen(textView,dice)
        showTheScreen(textView2,dice2)

    }

    private fun showTheScreen(textView: TextView, dice: Dice){
        val diceRoll = dice.roll()
        textView.text = diceRoll.toString()
    }
}


class Dice(val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}