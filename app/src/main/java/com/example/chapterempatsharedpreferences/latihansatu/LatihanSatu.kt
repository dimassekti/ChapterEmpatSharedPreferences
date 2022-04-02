package com.example.chapterempatsharedpreferences.latihansatu

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.chapterempatsharedpreferences.R
import kotlinx.android.synthetic.main.activity_latihan_satu.*

class LatihanSatu : AppCompatActivity() {

    lateinit var prefs : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_latihan_satu)

        if(getSharedPreferences("SF" , Context.MODE_PRIVATE).contains("ID")){
            viewdata()
        }

        prefs = getSharedPreferences("SF" , Context.MODE_PRIVATE)

        btn_save.setOnClickListener {
            SharedPrefExample()
        }


        btn_view.setOnClickListener {
            viewdata()
        }

        btn_clear.setOnClickListener {
            clear()
        }

    }

     fun SharedPrefExample(){

         val dataId = et_id.text.toString()
         val dataNama = et_nama.text.toString()

         prefs.edit().putString("ID", dataId).apply()
         prefs.edit().putString("NAMA", dataNama).apply()

     }

    fun viewdata(){

        prefs = getSharedPreferences("SF" , Context.MODE_PRIVATE)
        val getNama = prefs.getString("NAMA", "")
        val getId = prefs.getString("ID", "")

        tv_namaLat1.visibility = View.VISIBLE
        tv_idLat1.visibility = View.VISIBLE

//         tv_namaLat1.isVisible = true
//         tv_idLat1.isVisible = true

        tv_idLat1.text = "ID : $getId"
        tv_namaLat1.text = "NAMA : $getNama"
    }

    fun clear(){

        prefs.edit().clear().apply()

        startActivity(Intent(this, LatihanSatu::class.java))

    }
}