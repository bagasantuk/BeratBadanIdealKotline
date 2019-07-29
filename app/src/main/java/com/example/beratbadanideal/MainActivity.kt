package com.example.beratbadanideal

import androidx.appcompat.app.AppCompatActivity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()
    }

    fun tentang(view: View) {
        Toast.makeText(this@MainActivity, "Dibuat Oleh Bagas Antuk Pamukti Nugroho", Toast.LENGTH_SHORT).show()
    }

    fun hitung(view: View) {
        startActivity(Intent(this,HitungActivity::class.java))
    }
}
