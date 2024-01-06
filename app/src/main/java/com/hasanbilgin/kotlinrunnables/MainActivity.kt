package com.hasanbilgin.kotlinrunnables

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import kotlinx.coroutines.Runnable

class MainActivity : AppCompatActivity() {

    var number = 0

    //interfaceleri böle bırakmak şart
    var runnable: Runnable = Runnable { }
    var handler: Handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun startButtonOnClick(view: View) {
        number = 0
        runnable = object : Runnable {
            override fun run() {
                number++
                println("Time: ${number}")
                handler.postDelayed(this, 1000)
            }

        }
        handler.post(runnable)
    }

    fun stopButtonOnClick(view: View) {
        handler.removeCallbacks(runnable)
        number = 0
        println("Time: 0")
    }
}