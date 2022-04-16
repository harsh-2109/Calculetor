package com.example.calculetor

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var displayTv: TextView
    private lateinit var zeroBtn: Button
    private lateinit var oneBtn: Button
    private lateinit var twoBtn: Button
    private lateinit var threeBtn: Button
    private lateinit var fourBtn: Button
    private lateinit var fiveBtn: Button
    private lateinit var sixBtn: Button
    private lateinit var sevenBtn: Button
    private lateinit var eightBtn: Button
    private lateinit var nineBtn: Button
    private lateinit var plusBtn: Button
    private lateinit var minusBtn: Button
    private lateinit var multiplyBtn: Button
    private lateinit var divideBtn: Button
    private lateinit var clearBtn: Button
    private lateinit var equalsBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        widgetInit()
    }

    fun onDigit(view: View) {
        displayTv.append((view as Button).text)
    }

    fun onClear(view: View) {
        displayTv.text = ""
    }

    private fun widgetInit() {
        displayTv = findViewById(R.id.tvInput)
        zeroBtn = findViewById(R.id.btnZero)
        oneBtn = findViewById(R.id.btnOne)
        twoBtn = findViewById(R.id.btnTwo)
        threeBtn = findViewById(R.id.btnThree)
        fourBtn = findViewById(R.id.btnFour)
        fiveBtn = findViewById(R.id.btnFive)
        sixBtn = findViewById(R.id.btnSix)
        sevenBtn = findViewById(R.id.btnSeven)
        eightBtn = findViewById(R.id.btnEight)
        nineBtn = findViewById(R.id.btnNine)
        plusBtn = findViewById(R.id.btnPlus)
        minusBtn = findViewById(R.id.btnMinus)
        multiplyBtn = findViewById(R.id.btnMultiply)
        divideBtn = findViewById(R.id.btnDivide)
        equalsBtn = findViewById(R.id.btnEquals)
        clearBtn = findViewById(R.id.btnClear)
    }
}
