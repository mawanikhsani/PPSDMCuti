package com.example.ppsdmcuti.activity

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.ppsdmcuti.R
import java.util.Calendar

class NonPnsActivity : AppCompatActivity() {

    //inisialisasi
    private lateinit var btnTglAwal: Button
    private lateinit var btnTglAkhir: Button
    private var selectedStartDate : String? = null
    private var selectedEndDate : String? = null
    private val PICK_FILE_REQUEST_CODE = 1 // Request code for file picker
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_non_pns)

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
    private fun openFilePicker() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "*/*" // Allow all file types
        startActivityForResult(intent, PICK_FILE_REQUEST_CODE)
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