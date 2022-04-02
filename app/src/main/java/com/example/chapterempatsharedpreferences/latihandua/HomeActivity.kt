package com.example.chapterempatsharedpreferences.latihandua

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.chapterempatsharedpreferences.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    lateinit var prefs : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        prefs = getSharedPreferences("SFLATDUA", Context.MODE_PRIVATE)

        val usernameIn = prefs.getString("USERNAME", "")
        val passwordIn = prefs.getString("PASSWORD", "")

        tv_username_output.setText("Hello Mr/Ms $usernameIn")

        btn_logout.setOnClickListener {

            val ADBuilder = AlertDialog.Builder(this)

            ADBuilder.setTitle("Logout Hint")
                .setMessage("Hi $usernameIn Yakin Logout?")
                .setCancelable(true)
                .setPositiveButton("Ya"){ dialogInterface : DialogInterface, i : Int ->
                    logout()
                }
                .setNeutralButton("Tidak"){dialogInterface : DialogInterface, i : Int ->
                    ADBuilder.create().dismiss()
                }
                .show()

        }

    }

    fun logout(){
        prefs.edit().clear().apply()
        finish()
    }
}