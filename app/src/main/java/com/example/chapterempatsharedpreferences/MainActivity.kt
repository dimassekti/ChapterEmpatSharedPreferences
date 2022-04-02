package com.example.chapterempatsharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chapterempatsharedpreferences.latihandua.SplashDua
import com.example.chapterempatsharedpreferences.latihansatu.LatihanSatu
import com.example.chapterempatsharedpreferences.latihantiga.MainLatihanTigaActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        btn_satu.setOnClickListener {
            startActivity(Intent(this, MainSF::class.java))
        }


        btn_latihan_satu.setOnClickListener {
            startActivity(Intent(this, LatihanSatu::class.java))
        }

        btn_latihan_dua.setOnClickListener {
            startActivity(Intent(this, SplashDua::class.java))
        }

        btn_latihan_tiga.setOnClickListener {
            startActivity(Intent(this, MainLatihanTigaActivity::class.java))
        }

    }


}