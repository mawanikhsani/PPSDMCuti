package com.example.ppsdmcuti.activity

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.core.view.get
import com.example.ppsdmcuti.R
import java.util.Calendar

class PNSActivity : AppCompatActivity() {

    val divisi = arrayOf("Fungsional", "Struktural", "Bagian Perencanaan", "Rumah Tangga dan Sarana Pra Sarana",
        "Administrasi dan kepegawaian")
    val atasan = arrayOf("Nama Atasan 1", "Nama Atasan 2")
    val jnsCuti = arrayOf("Cuti Tahunan", "Cuti Sakit")
    private lateinit var btnTglAwal: Button
    private lateinit var btnTglAkhir: Button
    private var selectedStartDate : String? = null
    private var selectedEndDate : String? = null
    private val PICK_FILE_REQUEST_CODE = 1 // Request code for file picker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pnsactivity)

        //inisialisasi button
        btnTglAwal = findViewById(R.id.btnTglAwal)
        btnTglAkhir = findViewById(R.id.iBtntglAkhir)
        val uploadButton: Button = findViewById(R.id.btnUpDoc)

        btnTglAwal.setOnClickListener{
            showDatePickerDialog(true)
        }
        btnTglAkhir.setOnClickListener{
            showDatePickerDialog(false)
        }
        uploadButton.setOnClickListener {
            // Open file picker when the button is clicked
            openFilePicker()
        }

        //spinner divisi
        val div= findViewById<Spinner>(R.id.spDiv)
        val divAdapter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, divisi)
        div.adapter = divAdapter
        div.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(applicationContext, "Anda memilih divisi " + div[position], Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        //spinner atasan
        val ketua = findViewById<Spinner>(R.id.spAtasan)
        val ketuaAdapter  = ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, atasan)
        ketua.adapter = ketuaAdapter
        ketua.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(applicationContext, "Atasan anda adalah " + ketua[position], Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        //spinner jenis cuti
        val cuti = findViewById<Spinner>(R.id.spJenisCuti)
        val cutiAdapter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, jnsCuti)
        cuti.adapter = cutiAdapter
        cuti.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(applicationContext, "Anda akan mengambil " + cuti[position], Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }

    private fun openFilePicker() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "*/*" // Allow all file types
        startActivityForResult(intent, PICK_FILE_REQUEST_CODE)
    }

    private fun showDatePickerDialog(isStartDate: Boolean) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _, year, month, day ->
                val selectedDate = "$year-${month + 1}-${day}"

                if (isStartDate) {
                    selectedStartDate = selectedDate
                    btnTglAwal.text = selectedStartDate
                } else {
                    selectedEndDate = selectedDate
                    btnTglAkhir.text = selectedEndDate
                }
            },
            year,
            month,
            day
        )
        datePickerDialog.show()
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_FILE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            data?.data?.let { fileUri ->
                // Handle the selected file URI, you can use it to upload the file
                val selectedFilePath = fileUri.path
                // Do something with the selected file path
            }
        }
    }
}