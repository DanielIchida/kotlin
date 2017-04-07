package com.example.daniel.layoutpersonalizado

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import java.util.*

class InicioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)


        val task = object : TimerTask() {
            override fun run() {

                val mainIntent = Intent().setClass(
                        this@InicioActivity, MainActivity::class.java)
                startActivity(mainIntent)
                finish()
            }
        }

        val timer = Timer()
        timer.schedule(task, SPLASH_SCREEN_DELAY)
    }

    companion object {
        private val SPLASH_SCREEN_DELAY: Long = 6000
    }
}
