package com.example.rock_paper_scissors

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }

    override fun onStart() {
        super.onStart()
        val bundle = intent.extras
        val choiseOrdinal = bundle?.getInt(Choise::class.java.simpleName)
        choiseOrdinal ?: return
        val choise: Choise = Choise.values()[choiseOrdinal]
        val computerChoise = Choise.values()[Random.nextInt(Choise.values().size)]

        if(choise == Choise.ROCK && computerChoise == Choise.SCISSORS ||
            choise == Choise.SCISSORS && computerChoise == Choise.PAPER ||
            choise == Choise.PAPER && computerChoise == Choise.ROCK)
            info.text = "${info.text} выиграли!"
        else if(choise == computerChoise)
            info.text = "У вас ничья!!!"
        else
            info.text = "${info.text} проиграли..."

        if(computerChoise == Choise.ROCK)
            sign.text = "${sign.text} \uD83E\uDEA8"
        else if(computerChoise == Choise.SCISSORS)
            sign.text = "${sign.text} ✂️"
        else
            sign.text = "${sign.text} \uD83E\uDDFB"
    }
}