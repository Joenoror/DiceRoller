package com.joenoror.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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

        rollDice()

    }

    private fun rollDice() {
        //Create a dice object
        val dice = Dice(6)
        val textView:TextView = findViewById(R.id.textView)
        val imageView: ImageView = findViewById(R.id.imageView)
        showTheScreen(textView,imageView,dice)



        //Another dice object
        //val dice2 = Dice(10)
        //val textView2:TextView = findViewById(R.id.textView2)
        //showTheScreen(textView2,dice2)

    }

    private fun showTheScreen(textView: TextView,imageView: ImageView,dice: Dice){
        val diceRoll = dice.roll()
        textView.text = diceRoll.toString()
        //Si el dado es de 6 caras, cambio la imagen ya que la tenemos
        if(dice.numSides ==6){
            val drawableResource = when(diceRoll){
                1-> R.drawable.dice_1
                2-> R.drawable.dice_2
                3-> R.drawable.dice_3
                4-> R.drawable.dice_4
                5-> R.drawable.dice_5
                else-> R.drawable.dice_6
            }
            imageView.setImageResource(drawableResource)
            imageView.contentDescription = diceRoll.toString()
        }

    }
}


class Dice(val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}