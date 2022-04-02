package com.example.chapterempatsharedpreferences

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main_sfdua.*

class MainSFDua : AppCompatActivity() {

    lateinit var sf : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_sfdua)

        sf = getSharedPreferences("contoh sf" , Context.MODE_PRIVATE)

        val getNama = sf.getString("NAMA", "")

        tv_nama.text = getNama

        btn_logout.setOnClickListener {
            logout()
        }

    }

    fun logout(){
        val logoutsf = sf.edit()
        logoutsf.clear()
        logoutsf.apply()

        startActivity(Intent(this, MainSF::class.java))
        finish()

    }
}