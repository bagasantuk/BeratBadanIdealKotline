package com.example.beratbadanideal

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.View
import android.content.Intent
import android.net.Uri
import android.widget.TextView

class HasilActivity : AppCompatActivity() {
    internal lateinit var txtNama: TextView
    internal lateinit var txtBb: TextView
    internal lateinit var txtTb: TextView
    internal lateinit var txtBmi: TextView
    internal lateinit var txtHasil: TextView
    internal lateinit var txtKet: TextView
    internal var nama: String? = null
    internal var hasil: String? = null
    internal var ket: String? = null

    internal var bb: Double = 0.toDouble()
    internal var tb: Double = 0.toDouble()
    internal var bmi: Double = 0.toDouble()

    internal var defaultValue = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil)

        txtNama = findViewById<View>(R.id.text_view_hasil_nama) as TextView

        txtBb = findViewById<View>(R.id.text_view_hasil_bb) as TextView

        txtTb = findViewById<View>(R.id.text_view_hasil_tb) as TextView

        txtBmi = findViewById<View>(R.id.text_view_hasil_bmi) as TextView

        txtHasil = findViewById<View>(R.id.text_view_hasil) as TextView

        txtKet = findViewById<View>(R.id.text_view_hasil_ket) as TextView

        //mengambil variabel dari activity lain

        val intent = intent

        //String pesan = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        nama = intent.getStringExtra("EXTRA_NAMA")

        bb = intent.getDoubleExtra("EXTRA_BB", defaultValue)

        tb = intent.getDoubleExtra("EXTRA_TB", defaultValue)

        bmi = intent.getDoubleExtra("EXTRA_BMI", defaultValue)

        hasil = intent.getStringExtra("EXTRA_HASIL")

        ket = intent.getStringExtra("EXTRA_KET")

        txtNama.text = "Nama : " + nama!!

        txtBb.text = "Berat Badani : $bb"

        txtTb.text = "Tinggi Badan : $tb"

        txtBmi.text = "BMI : " + String.format("%.1f", bmi)

        txtHasil.text = "Hasil : " + hasil!!

        txtKet.text = "Keterangan : " + ket!!
    }

    fun bagikanKeEmail(view: View) {
        val emailIntent = Intent(Intent.ACTION_SENDTO)
        emailIntent.data = Uri.parse("mailto:") // only email apps should handle this

        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Laporan Berat Badan " + nama!!)
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Nama : " + nama + "\nBerat Badan : " + bb + "\nTinggi Badan : " + tb + "\nBMI : "

                + bmi + "\nHasil : " + hasil + "\nKeterangan : " + ket)

        if (emailIntent.resolveActivity(packageManager) != null) {
            startActivity(emailIntent)
        }
    }
}
