package com.example.calculetor

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.lang.ArithmeticException

class MainActivity : AppCompatActivity() {

    private lateinit var displayTv: TextView
    private var lastNumeric: Boolean = true
    private var lastDot: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        displayTv = findViewById(R.id.tvInput)
    }

    fun onDigit(view: View) {
        displayTv.append((view as Button).text)
        lastNumeric = true
    }

    fun onClear(view: View) {
        displayTv.text = ""
    }

    fun onDecimalPoint(view: View) {
        if (lastNumeric && !lastDot) {
            displayTv.append((view as Button).text)
            lastNumeric = false
            lastDot = true
        }
    }

    fun onOperator(view: View) {
        displayTv.text.let {
            if (lastNumeric && !isOperatorAdded(it.toString())) {
                displayTv.append((view as Button).text)
                lastDot = false
                lastNumeric = false
            }
        }
    }

    private fun isOperatorAdded(value: String): Boolean =
        if (value.startsWith("-"))
            false
        else
            value.contains("+") ||
                value.contains("-") ||
                value.contains("*") ||
                value.contains("/")

    private fun removeZeroAfterDot(result: String): String =
        if (result.contains(".0")) (result.substring(0, result.length - 2)) else result

    fun onEqual(view: View) {
        if (lastNumeric) {
            var tvValue = displayTv.text.toString()
            var prefix = ""
            try {
                if (tvValue.startsWith("-")) {
                    prefix = "-"
                    tvValue = tvValue.substring(1)
                }
                if (tvValue.contains("/")) {
                    val splitValue = tvValue.split("/")

                    var one = splitValue[0]
                    val two = splitValue[1]

                    if (prefix.isNotEmpty()) {
                        one = prefix + one
                    }

                    displayTv.text =
                        removeZeroAfterDot((one.toDouble() / two.toDouble()).toString())
                }
                if (tvValue.contains("*")) {
                    val splitValue = tvValue.split("*")

                    var one = splitValue[0]
                    val two = splitValue[1]

                    if (prefix.isNotEmpty()) {
                        one = prefix + one
                    }

                    displayTv.text =
                        removeZeroAfterDot((one.toDouble() * two.toDouble()).toString())
                }
                if (tvValue.contains("+")) {
                    val splitValue = tvValue.split("+")

                    var one = splitValue[0]
                    val two = splitValue[1]

                    if (prefix.isNotEmpty()) {
                        one = prefix + one
                    }

                    displayTv.text =
                        removeZeroAfterDot((one.toDouble() + two.toDouble()).toString())
                }
                if (tvValue.contains("-")) {
                    val splitValue = tvValue.split("-")

                    var one = splitValue[0]
                    val two = splitValue[1]

                    if (prefix.isNotEmpty()) {
                        one = prefix + one
                    }

                    displayTv.text =
                        removeZeroAfterDot((one.toDouble() - two.toDouble()).toString())
                }
            } catch (e: ArithmeticException) {
                e.stackTrace
            }
        }
    }
}
