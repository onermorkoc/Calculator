package com.onermorkoc.hesapmakinesi

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity(){

    private lateinit var sharedPreferences: SharedPreferences
    var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = this.getSharedPreferences("Calculator", Context.MODE_PRIVATE)
        night_button.setOnClickListener {
            val status = sharedPreferences.getString("night_mode", "")
            if (status == "no"){
                sharedPreferences.edit().putString("night_mode", "yes").apply()
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }else{
                sharedPreferences.edit().putString("night_mode", "no").apply()
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        more.setOnClickListener {
            if (tablerow.visibility == View.GONE){
                more.rotationX = +360F
                tablerow.visibility = View.VISIBLE
            }else{
                more.rotationX = -180F
                tablerow.visibility = View.GONE
            }
        }
    }

    fun add_text(text: String){
        val old = textView2.text.toString()
        val new = old + text
        textView2.text = new
    }

    fun zero(view: View){
        add_text("0")
    }

    fun one(view: View){
        add_text("1")
    }

    fun two(view: View){
        add_text("2")
    }

    fun three(view: View){
        add_text("3")
    }

    fun four(view: View){
        add_text("4")
    }

    fun five(view: View){
        add_text("5")
    }

    fun six(view: View){
        add_text("6")
    }

    fun seven(view: View){
        add_text("7")
    }

    fun eight(view: View){
        add_text("8")
    }

    fun nine(view: View){
        add_text("9")
    }

    fun point(view: View){
        add_text(".")
    }

    fun divide(view: View){
        add_text("/")
    }

    fun multiply(view: View){
        add_text("*")
    }

    fun percentage(view: View){
        add_text("%")
    }

    fun add(view: View){
        add_text("+")
    }

    fun minus(view: View){
        add_text("-")
    }

    fun factorial_button(view: View){
        add_text("!")
    }

    fun pi(view: View){
        add_text("π")
    }

    fun exponen(view: View){
        add_text("^")
    }

    fun root(view: View){
        add_text("√(")
        i += 1
    }

    fun all_delete(view: View){
        textView2.text=""
        textView2.hint="0"
        i = 0
    }

    fun delete(view: View){
        val text=textView2.text.toString()
        if (text.isNotEmpty()){
            textView2.text = text.substring(0, text.length - 1)
        }else{
            textView2.hint = "0"
        }
        i -= 1
    }

    fun brace(view: View){

        if (i % 2 == 0){
            add_text("(")
        }else{
            add_text(")")
        }
        i += 1
    }

    fun result(view: View){

        if (textView2.text.isNotEmpty()){
            try {

                var text = textView2.text.toString()
                text = text.replace("%","/100*")
                text = text.replace("π","*3.14")
                text = text.replace("√", "sqrt")
                if (text.contains('!')){
                    text = text.replace("!", factorial(text.substring(0, text.length - 1)))
                }

                val expressionBuilder=ExpressionBuilder(text).build().evaluate()

                if (expressionBuilder == expressionBuilder.toLong().toDouble()){
                    textView2.hint=expressionBuilder.toLong().toString()
                    textView2.text=""
                }else{
                    textView2.hint = expressionBuilder.toString()
                    textView2.text=""
                }
            }catch (e:Exception){
                textView2.hint="Error"
                textView2.text=""
            }
        }else if (textView2.hint == "Error"){
            textView2.hint = "0"
        }
        i = 0
    }

    fun factorial(number : String) : String {

        val arrayList = arrayListOf<Char>()
        arrayList.add('+')
        arrayList.add('-')
        arrayList.add('*')
        arrayList.add('/')
        arrayList.add('(')
        arrayList.add(')')
        arrayList.add('!')
        arrayList.add('%')
        arrayList.add('^')
        arrayList.add('√')

        var string = ""
        var index = number.length - 1
        while (index >= 0){
            if (arrayList.contains(number[index])){
                break
            }
            else if (number[index] in '0'..'9'){
                string += number[index]
            }
            index--
        }

        var number = string.reversed().toInt() - 1
        string=""

        while (number > 0){
            string += "*$number"
            number--;
        }
        return string
    }
}