package com.example.dice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        val introtext: TextView = findViewById(R.id.textView)
        var cnt = 0
        val di: ImageView = findViewById(R.id.imageView)
        di.setImageResource(R.drawable.dice_2)
        rollButton.setOnClickListener {
            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)

            toast.show()
            rolldice()
          introtext.text=" ${cnt}"
            cnt=cnt+1
            if(cnt>50){
                introtext.text="abb bass bhi kar bhai"
            }

        }




    }


    private fun rolldice() {
        val d1 = Dice(6)

        val d1roll = d1.roll()
        val diceImage: ImageView = findViewById(R.id.imageView)
        diceImage.setImageResource(R.drawable.dice_2)
        when (d1roll) {
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            else -> diceImage.setImageResource(R.drawable.dice_6)
        }
    }
}





class Dice(private val sides: Int){
    fun roll(): Int{
       return (1..sides).random()
    }
}

