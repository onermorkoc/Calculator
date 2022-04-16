package com.onermorkoc.hesapmakinesi

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatDelegate

class MainActivity2 : AppCompatActivity() {
    private lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        sharedPreferences = getSharedPreferences("Calculator", Context.MODE_PRIVATE)
        putSPData()
        check_night_mode()

        Handler().postDelayed(Runnable {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        },700)
    }

    fun check_night_mode(){
        val status = sharedPreferences.getString("night_mode", "")
        if (status == "no"){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
    }

    fun putSPData(){
        val check = sharedPreferences.getString("night_mode", "")
        if (check == ""){
            sharedPreferences.edit().putString("night_mode", "no").apply()
        }
    }
}