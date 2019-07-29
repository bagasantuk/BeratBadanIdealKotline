package com.example.beratbadanideal

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HitungActivity : AppCompatActivity() {
    internal lateinit var edtNama: EditText
    internal lateinit var edtBB: EditText
    internal lateinit var edtTB: EditText

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hitung)
        supportActionBar!!.title = "Hitung BMI Ideal"

        edtNama = findViewById<View>(R.id.edit_text_nama) as EditText

        edtBB = findViewById<View>(R.id.edit_text_bb) as EditText

        edtTB = findViewById<View>(R.id.edit_text_tb) as EditText
    }

    fun cekHasil(view: View) {
        var bmi = 0.0
        var beratBadan = 0.0

        var tinggiBadan = 0.0
        val nama = edtNama.text.toString().trim { it <= ' ' }
        val sBeratBadan = edtBB.text.toString().trim { it <= ' ' }
        val sTinggiBadan = edtTB.text.toString().trim { it <= ' ' }
        val sbmi = edtTB.text.toString().trim { it <= ' ' }
        var hasil = ""
        var ket = ""

        if (edtNama.text.toString() == "" ||
                edtBB.text.toString() == "" ||
                edtTB.text.toString() == "") {
            Toast.makeText(applicationContext, "Mohon untuk melengkapi data", Toast.LENGTH_SHORT).show()
        } else {

            beratBadan = java.lang.Double.parseDouble(sBeratBadan)

            tinggiBadan = java.lang.Double.parseDouble(sTinggiBadan)

            //rumus
            //BMI = Berat Badan kg/ (Tinggi Badan m * Tinggi Badan m)

            bmi = beratBadan / (tinggiBadan * tinggiBadan * 0.0001)
            Log.d("tag", "Nama = $nama\nbmi = $bmi")

            if (bmi < 18.5) {

                //Log.d("keterangan Perempuan", "Under Weight/Kurus – Sebaiknya mulai menambah berat badan dan mengkonsumsi makanan berkarbohidrat di imbangi dengan olah raga");

                hasil = "Under Weight/Kurus"
                ket = "Sebaiknya mulai menambah berat badan dan mengkonsumsi makanan berkarbohidrat di imbangi dengan olah raga"
            } else if (bmi >= 18.5 && bmi < 25) {

                //Log.d("keterangan Perempuan","Normal Weight/Normal – Bagus, berat badan anda termasuk kategori ideal");

                hasil = "Normal Weight/Normal"
                ket = "Bagus, berat badan anda termasuk kategori ideal"
            } else if (bmi >= 25 && bmi < 30) {

                //Log.d("keterangan Perempuan","Over Weight/Kegemukan – anda sudah masuk kategori gemuk. sebaiknya hindari makanan berlemak dan mulailah meningkatkan olahraga seminggu minimal 2 kali");

                hasil = "Over Weight/Kegemukan"
                ket = "Anda sudah masuk kategori gemuk. sebaiknya hindari makanan berlemak dan mulailah meningkatkan olahraga seminggu minimal 2 kali"
            } else {

                //Log.d("keterangan Perempuan","\tObesitas – Sebaiknya segera membuat program menurunkan berat badan karena anda termasuk kategori obesitas/ terlalu gemuk dan tidak baik bagi kesehatan");

                hasil = "Obesitas"
                ket = "Sebaiknya segera membuat program menurunkan berat badan karena anda termasuk kategori obesitas/ terlalu gemuk dan tidak baik bagi kesehatan"
            }
            Log.d("tag", "Nama = $nama\nbmi = $bmi\nhasil : $hasil\nket : $ket\n")
        }

        val intent = Intent(this@HitungActivity, HasilActivity::class.java)
        intent.putExtra(
                "EXTRA_NAMA", nama)
        intent.putExtra(
                "EXTRA_BB", beratBadan)
        intent.putExtra(
                "EXTRA_TB", tinggiBadan)
        intent.putExtra(
                "EXTRA_BMI", bmi)
        intent.putExtra(
                "EXTRA_HASIL", hasil)
        intent.putExtra(
                "EXTRA_KET", ket)
        startActivity(intent)
    }

}
