package com.example.funwithprimes

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var points = 0
    private var prime = (1..100).random()
    private var errors = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.primeView).text = "$prime"
    }

    fun leftClick(view: View) {
        game(true)

    }

    fun rightClick(view: View) {
        game(false)
    }

    fun ifPrime(num : Int): Boolean {
        var flag = true
        var i = 2
        while (i <= num / 2){
            if(num % i ==0){
                flag = false
                break
            }
            i++
        }
        return flag
    }

    fun game(guess : Boolean){
        if(ifPrime(prime) == guess){
            points++
            findViewById<TextView>(R.id.points).text = "Guessed: $points"
            findViewById<TextView>(R.id.errors).setTextColor(Color.BLACK)
        }
        else{
            errors++
            findViewById<TextView>(R.id.errors).setTextColor(Color.RED)
            findViewById<TextView>(R.id.errors).text = "Errors: $errors"
        }
        prime = (1..100).random()
        findViewById<TextView>(R.id.primeView).text = "$prime"
    }
}
