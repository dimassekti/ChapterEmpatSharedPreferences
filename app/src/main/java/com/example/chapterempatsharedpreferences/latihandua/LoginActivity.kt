package com.example.chapterempatsharedpreferences.latihandua

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chapterempatsharedpreferences.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var prefs : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        if(getSharedPreferences("SFLATDUA", Context.MODE_PRIVATE).contains("USERNAME")){
            startActivity(Intent(this, HomeActivity::class.java))
        }

        prefs = getSharedPreferences("SFLATDUA", Context.MODE_PRIVATE)

        SharedPrefLatDua()

    }

    fun SharedPrefLatDua(){

        btn_login_a.setOnClickListener {
            val dataUsername = et_username.text.toString()
            val dataPassword = et_password.text.toString()

            prefs.edit().putString("USERNAME", dataUsername).apply()
            prefs.edit().putString("PASSWORD", dataPassword).apply()

            startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
        }
    }
}