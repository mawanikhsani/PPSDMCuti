package com.example.ppsdmcuti.activity

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.example.ppsdmcuti.R
import java.util.Calendar

class NonPnsActivity : AppCompatActivity() {

    private lateinit var ivBackHome: ImageView
    private lateinit var tvNama: TextView
    private lateinit var etNama: EditText
    private lateinit var tvTglAwalCuti: TextView
    private lateinit var etTglAwal: EditText
    private lateinit var btnTglAwal: ImageButton
    private lateinit var tvTglAkhir: TextView
    private lateinit var etTglAkhir: EditText
    private lateinit var btnTglAkhir: ImageButton
    private lateinit var tvUpDoc: TextView
    private lateinit var btnUpDoc: Button
    private lateinit var tvAlasan: TextView
    private lateinit var etAlasan: EditText
    private lateinit var tvitemdipilih: TextView


    // Constants for file selection
    private val PICK_DOCUMENT_REQUEST = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_non_pns)

        // Inisialisasi ImageView
        ivBackHome = findViewById(R.id.ivBackHome)
        tvNama = findViewById(R.id.tvNama)
        etNama = findViewById(R.id.etNama)
        tvTglAwalCuti = findViewById(R.id.tvTglAwalCuti)
        etTglAwal = findViewById(R.id.etTglAwal)
        btnTglAwal = findViewById(R.id.btnTglAwal)
        tvTglAkhir = findViewById(R.id.tvTglAkhir)
        etTglAkhir = findViewById(R.id.etTglAkhir)
        btnTglAkhir = findViewById(R.id.btnTglAkhir)
        tvUpDoc = findViewById(R.id.tvUpDoc)
        btnUpDoc = findViewById(R.id.btnUpDoc)
        tvAlasan = findViewById(R.id.tvAlasan)
        etAlasan = findViewById(R.id.etAlasan)
        tvitemdipilih = findViewById(R.id.tvitemdipilih)


        // Menambahkan listener klik pada ImageView
        ivBackHome.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        etNama.setOnClickListener {
        }

        // Set listener untuk etAlasan
        etAlasan.setOnClickListener {

        }

        btnUpDoc.setOnClickListener {
            // Panggil metode untuk membuka file manager dan memilih dokumen
            openFileManager()
        }

        // Set listener untuk btnTglAwal
        btnTglAwal.setOnClickListener {
            // Tampilkan DatePickerDialog untuk memilih tanggal awal
            showDatePickerDialogAwal(etTglAwal)
        }

        // Set listener untuk btnTglAkhir
        btnTglAkhir.setOnClickListener {
            // Tampilkan DatePickerDialog untuk memilih tanggal akhir
            showDatePickerDialogAkhir(etTglAkhir)
        }

    }

    private fun openFileManager() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "*/*" // Semua jenis file
        startActivityForResult(intent, PICK_DOCUMENT_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_DOCUMENT_REQUEST && resultCode == Activity.RESULT_OK) {
            data?.data?.let { selectedFileUri ->
                handleSelectedFile(selectedFileUri)
            }
        }
    }

    private fun handleSelectedFile(uri: Uri) {
        val fileName = getFileName(uri)
        tvitemdipilih.text = "Selected File: $fileName"

    }

    private fun getFileName(uri: Uri): String {
        val cursor = contentResolver.query(uri, null, null, null, null)
        cursor?.use {
            val nameIndex = it.getColumnIndexOrThrow("_display_name")
            it.moveToFirst()
            return it.getString(nameIndex)
        }
        return "Unknown"
    }


    private fun showDatePickerDialogAwal(etTglAwal: EditText) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, selectedDay ->
                // Menetapkan tanggal yang dipilih ke dalam etTglAwal
                this.etTglAwal.setText("$selectedDay-${selectedMonth + 1}-$selectedYear")
            },
            year, month, day
        )

        // Tampilkan DatePickerDialog
        datePickerDialog.show()
    }

    private fun showDatePickerDialogAkhir(etTglAkhir: EditText) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, selectedDay ->
                // Menetapkan tanggal yang dipilih ke dalam etTglAkhir
                this.etTglAkhir.setText("$selectedDay-${selectedMonth + 1}-$selectedYear")
            },
            year, month, day
        )

        // Tampilkan DatePickerDialog
        datePickerDialog.show()
    }

//    //inisialisasi
//    private lateinit var btnTglAwal: Button
//    private lateinit var btnTglAkhir: Button
//    private var selectedStartDate : String? = null
//    private var selectedEndDate : String? = null
//    private val PICK_FILE_REQUEST_CODE = 1 // Request code for file picker
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_non_pns)
//
//        btnTglAwal = findViewById(R.id.btnTglAwal)
//        btnTglAkhir = findViewById(R.id.btnTglAkhir)
//        val uploadButton: Button = findViewById(R.id.btnUpDoc)
//
//        btnTglAwal.setOnClickListener{
//            showDatePickerDialog(true)
//        }
//        btnTglAkhir.setOnClickListener{
//            showDatePickerDialog(false)
//        }
//        uploadButton.setOnClickListener {
//            // Open file picker when the button is clicked
//            openFilePicker()
//        }
//    }
//
//    private fun showDatePickerDialog(isStartDate: Boolean) {
//        val calendar = Calendar.getInstance()
//        val year = calendar.get(Calendar.YEAR)
//        val month = calendar.get(Calendar.MONTH)
//        val day = calendar.get(Calendar.DAY_OF_MONTH)
//
//        val datePickerDialog = DatePickerDialog(
//            this,
//            { _, year, month, day ->
//                val selectedDate = "$year-${month + 1}-${day}"
//
//                if (isStartDate) {
//                    selectedStartDate = selectedDate
//                    btnTglAwal.text = selectedStartDate
//                } else {
//                    selectedEndDate = selectedDate
//                    btnTglAkhir.text = selectedEndDate
//                }
//            },
//            year,
//            month,
//            day
//        )
//        datePickerDialog.show()
//    }
//    private fun openFilePicker() {
//        val intent = Intent(Intent.ACTION_GET_CONTENT)
//        intent.type = "*/*" // Allow all file types
//        startActivityForResult(intent, PICK_FILE_REQUEST_CODE)
//    }
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if (requestCode == PICK_FILE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
//            data?.data?.let { fileUri ->
//                // Handle the selected file URI, you can use it to upload the file
//                val selectedFilePath = fileUri.path
//                // Do something with the selected file path
//            }
//        }
//    }
}