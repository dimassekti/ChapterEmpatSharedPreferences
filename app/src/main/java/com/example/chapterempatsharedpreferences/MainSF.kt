package com.example.chapterempatsharedpreferences

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main_sf.*

class MainSF : AppCompatActivity() {

    lateinit var prefs : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_sf)

        if(getSharedPreferences("contoh sf" , Context.MODE_PRIVATE).contains("NAMA")){
            startActivity(Intent(this, MainSFDua::class.java))
        }

        prefs = getSharedPreferences("contoh sf" , Context.MODE_PRIVATE)
        SharedPrefExample()

    }

    fun SharedPrefExample(){
        btn_simpan.setOnClickListener {

            //LANGKAH MEMASUKAN DATA KE SHARED PREFERENCES
            val dataNama = et_nama.text.toString()
            val sf = prefs.edit()

            sf.putString("NAMA", dataNama)
            sf.putString("DUA", "qwerty")
            sf.apply()

            startActivity(Intent(this, MainSFDua::class.java))
            finish()

        }
    }
}