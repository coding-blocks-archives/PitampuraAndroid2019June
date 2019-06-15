package com.codingblocks.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    private var firstNum = 0.0
    private var secondNum = 0.0
    private var currOp = '$'

    private var isResultSet = false

    private val calcLogic = CalcLogic()

    private val btnarr = arrayOfNulls<Button>(10)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        attachListeners()
    }

    private fun attachListeners() {

        val btnArray = arrayOf(
            btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,
            btnEq, btnClr,
            btnAdd, btnMul, btnSub, btnDiv
        )
        for (btn in btnArray){
            btn.setOnClickListener(this)
        }
    }

    private fun showResult() {
        val result = calcLogic.evaluate(firstNum, secondNum, currOp)
        tvResult.text = result.toString()

        firstNum = result
        isResultSet = true


    }

    private fun displayNum(currNum: Int) {
        if (currOp != '$') {
            secondNum = secondNum * 10 + currNum
            tvSecond.text = secondNum.toString()
        } else {
            firstNum = firstNum * 10 + currNum
            tvFirst.text = firstNum.toString()
        }
    }

    private fun displayOp(inputOp: Char) {

        if (isResultSet) {
            clear(false)
            tvFirst.text = firstNum.toString()
        }
        currOp = inputOp
        tvOp.text = currOp.toString()

    }

    private fun clear(allClear: Boolean = true) {
        tvResult.text = ""
        tvOp.text = ""
        tvFirst.text = ""
        tvSecond.text = ""

        if (allClear) {
            firstNum = 0.0
        }
        secondNum = 0.0
        currOp = '$'
        isResultSet = false
    }

    override fun onClick(p0: View) {
        when (p0.id) {
            R.id.btn0 -> displayNum(0)
            R.id.btn1 -> displayNum(1)
            R.id.btn2 -> displayNum(2)
            R.id.btn3 -> displayNum(3)
            R.id.btn4 -> displayNum(4)
            R.id.btn5 -> displayNum(5)
            R.id.btn6 -> displayNum(6)
            R.id.btn7 -> displayNum(7)
            R.id.btn8 -> displayNum(8)
            R.id.btn9 -> displayNum(9)
            R.id.btnAdd -> displayOp('+')
            R.id.btnSub -> displayOp('-')
            R.id.btnMul -> displayOp('*')
            R.id.btnDiv -> displayOp('/')
            R.id.btnEq -> showResult()
            R.id.btnClr -> clear()
        }
    }
}
