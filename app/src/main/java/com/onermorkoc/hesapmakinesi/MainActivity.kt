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

    fun left_brace(view: View){
        add_text("(")
    }

    fun right_brace(view: View){
        add_text(")")
    }

    fun multiply(view: View){
        add_text("*")
    }

    fun add(view: View){
        add_text("+")
    }

    fun minus(view: View){
        add_text("-")
    }

    fun all_delete(view: View){
        textView2.text=""
        textView2.hint="0"
    }

    fun delete(view: View){
        val text=textView2.text.toString()
        if (text.isNotEmpty()){
            textView2.text = text.substring(0, text.length - 1)
        }
    }

    fun result(view: View){
       try {
           val expressionBuilder=ExpressionBuilder(textView2.text.toString()).build().evaluate()
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
    }
}