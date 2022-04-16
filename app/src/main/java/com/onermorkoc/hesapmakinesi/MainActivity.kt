package com.onermorkoc.hesapmakinesi

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun sifiroc(view: View){
        val varolansayi=textView2.text.toString()
        val yenisayi=varolansayi+"0"
        textView2.text=yenisayi
    }
    fun biroc(view: View){
        val varolansayi=textView2.text.toString()
        val yenisayi=varolansayi+"1"
        textView2.text=yenisayi
    }
    fun ikioc(view: View){
        val varolansayi=textView2.text.toString()
        val yenisayi=varolansayi+"2"
        textView2.text=yenisayi
    }
    fun ucoc(view: View){
        val varolansayi=textView2.text.toString()
        val yenisayi=varolansayi+"3"
        textView2.text=yenisayi
    }
    fun dortoc(view: View){
        val varolansayi=textView2.text.toString()
        val yenisayi=varolansayi+"4"
        textView2.text=yenisayi
    }
    fun besoc(view: View){
        val varolansayi=textView2.text.toString()
        val yenisayi=varolansayi+"5"
        textView2.text=yenisayi
    }
    fun altioc(view: View){
        val varolansayi=textView2.text.toString()
        val yenisayi=varolansayi+"6"
        textView2.text=yenisayi
    }
    fun  yedioc(view: View){
        val varolansayi=textView2.text.toString()
        val yenisayi=varolansayi+"7"
        textView2.text=yenisayi
    }
    fun sekizoc(view: View){
        val varolansayi=textView2.text.toString()
        val yenisayi=varolansayi+"8"
        textView2.text=yenisayi
    }
    fun dokuzoc(view: View){
        val varolansayi=textView2.text.toString()
        val yenisayi=varolansayi+"9"
        textView2.text=yenisayi
    }
    fun noktaoc(view: View){
        val varolansayi=textView2.text.toString()
        val yenisayi=varolansayi+"."
        textView2.text=yenisayi
    }
    fun boloc(view: View){
        val varolansayi=textView2.text.toString()
        val yenisayi=varolansayi+"/"
        textView2.text=yenisayi
    }
    fun parantezsoloc(view: View){
        val varolansayi=textView2.text.toString()
        val yenisayi=varolansayi+"("
        textView2.text=yenisayi
    }
    fun parantezsagoc(view: View){
        val varolansayi=textView2.text.toString()
        val yenisayi=varolansayi+")"
        textView2.text=yenisayi
    }
    fun siloc(view: View){
        val varolansayi=textView2.text.toString()
        if (varolansayi.isNotEmpty()){
            val yenisayi=varolansayi.substring(0,varolansayi.length-1)
            textView2.text=yenisayi
        }
    }
    fun carpoc(view: View){
        val varolansayi=textView2.text.toString()
        val yenisayi=varolansayi+"*"
        textView2.text=yenisayi
    }
    fun toplaoc(view: View){
        val varolansayi=textView2.text.toString()
        val yenisayi=varolansayi+"+"
        textView2.text=yenisayi
    }
    fun cikaroc(view: View){
        val varolansayi=textView2.text.toString()
        val yenisayi=varolansayi+"-"
        textView2.text=yenisayi
    }
    fun temizleoc(view: View){
        textView2.text=""
        textView2.hint=""
    }
    fun sonucoc(view: View){
       try {
           val a=ExpressionBuilder(textView2.text.toString()).build()
           val b=a.evaluate()
           val c=b.toLong()
           if (b==c.toDouble()){
               textView2.hint=c.toString()
               textView2.text=""
           }else{
               textView2.hint=b.toString()
               textView2.text=""
           }
       }catch (e:Exception){
           textView2.hint="Error"
           textView2.text=""
       }
    }
}