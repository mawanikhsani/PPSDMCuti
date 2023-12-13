package com.example.ppsdmcuti.activity

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.get
import com.example.ppsdmcuti.R
import java.util.Calendar

class PNSActivity : AppCompatActivity() {

    // Inisialisasi view
    private lateinit var ivBackHome: ImageView
    private lateinit var tvNama: TextView
    private lateinit var etNama: EditText
    private lateinit var tvNIP: TextView
    private lateinit var etNIP: EditText
    private lateinit var tvDivisi: TextView
    private lateinit var spDiv: Spinner
    private lateinit var tvAtasan: TextView
    private lateinit var spAtasan: Spinner
    private lateinit var tvJenisCuti: TextView
    private lateinit var spJenisCuti: Spinner
    private lateinit var tvTglAwalCuti: TextView
    private lateinit var etTglAwal: EditText
    private lateinit var btnTglAwal: ImageButton
    private lateinit var tvTglAkhir: TextView
    private lateinit var etTglAkhir: EditText
    private lateinit var btnTglAkhir: ImageButton
    private lateinit var tvAlamat: TextView
    private lateinit var etAlamat: EditText
    private lateinit var tvUpDoc: TextView
    private lateinit var btnUpDoc: Button
    private lateinit var tvAlasan: TextView
    private lateinit var etAlasan: EditText
    private lateinit var btnAjukan: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pnsactivity)

        // Inisialisasi view
        ivBackHome = findViewById(R.id.ivBackHome)
        tvNama = findViewById(R.id.tvNama)
        etNama = findViewById(R.id.etNama)
        tvNIP = findViewById(R.id.tvNIP)
        etNIP = findViewById(R.id.etNIP)
        tvDivisi = findViewById(R.id.tvDivisi)
        spDiv = findViewById(R.id.spDiv)
        tvAtasan = findViewById(R.id.tvAtasan)
        spAtasan = findViewById(R.id.spAtasan)
        tvJenisCuti = findViewById(R.id.tvJenisCuti)
        spJenisCuti = findViewById(R.id.spJenisCuti)
        tvTglAwalCuti = findViewById(R.id.tvTglAwalCuti)
        etTglAwal = findViewById(R.id.etTglAwal)
        btnTglAwal = findViewById(R.id.btnTglAwal)
        tvTglAkhir = findViewById(R.id.tvTglAkhir)
        etTglAkhir = findViewById(R.id.etTglAkhir)
        btnTglAkhir = findViewById(R.id.btnTglAkhir)
        tvAlamat = findViewById(R.id.tvAlamat)
        etAlamat = findViewById(R.id.etAlamat)
        tvUpDoc = findViewById(R.id.tvUpDoc)
        btnUpDoc = findViewById(R.id.btnUpDoc)
        tvAlasan = findViewById(R.id.tvAlasan)
        etAlasan = findViewById(R.id.etAlasan)
        btnAjukan = findViewById(R.id.btnAjukan)

        // Set listener untuk ivBackHome
        ivBackHome.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Set listener untuk etNama
        etNama.setOnClickListener {

        }

        // Set listener untuk etNIP
        etNIP.setOnClickListener {

        }

        // Set listener untuk etAlamat
        etAlamat.setOnClickListener {

        }

        // Set listener untuk etAlasan
        etAlasan.setOnClickListener {

        }

        // Set listener untuk btnAjukan
        btnAjukan.setOnClickListener {
            // Menampilkan pemberitahuan "Berhasil mengajukan"
            Toast.makeText(this, "Berhasil mengajukan", Toast.LENGTH_SHORT).show()
        }

        // Inisialisasi data untuk Spinner
        val divisiOptions = arrayOf("Fungsional", "Struktural", "Bagian Perencanaan", "Rumah Tangga dan Sarana Pra Sarana", "Administrasi dan kepegawaian")

        // Buat ArrayAdapter menggunakan divisiOptions dan layout bawaan untuk Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, divisiOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spDiv.adapter = adapter

        // Inisialisasi data untuk Spinner Atasan
        val atasanOptions = arrayOf("Nama Atasan 1", "Nama Atasan 2")

        // Buat ArrayAdapter menggunakan atasanOptions dan layout bawaan untuk Spinner
        val atasanAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, atasanOptions)
        atasanAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spAtasan.adapter = atasanAdapter


        // Inisialisasi data untuk Spinner Jenis Cuti
        val jenisCutiOptions = arrayOf("Cuti Tahunan", "Cuti Sakit", "Cuti Karena Alasan Penting", "Cuti Besar", "Cuti Melahirkan", "Cuti diluar Tanggungan Negara")

        // Buat ArrayAdapter menggunakan jenisCutiOptions dan layout bawaan untuk Spinner
        val jenisCutiAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, jenisCutiOptions)
        jenisCutiAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spJenisCuti.adapter = jenisCutiAdapter

        // Set listener untuk spDiv
        spDiv.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Menampilkan pilihan yang dipilih
                //Toast.makeText(this@PNSActivity, "Selected: ${divisiOptions[position]}", Toast.LENGTH_SHORT).show()
                tvDivisi.text = "Jenis Cuti: ${divisiOptions[position]}"
                tvDivisi.setTextColor(ContextCompat.getColor(this@PNSActivity, android.R.color.black))
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        // Set listener untuk spAtasan
        spAtasan.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Menampilkan pilihan yang dipilih dari Spinner Atasan
                //Toast.makeText(this@PNSActivity, "Selected Atasan: ${atasanOptions[position]}", Toast.LENGTH_SHORT).show()
                tvAtasan.text = "Jenis Cuti: ${atasanOptions[position]}"
                tvAtasan.setTextColor(ContextCompat.getColor(this@PNSActivity, android.R.color.black))
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        // Set listener untuk spJenisCuti
        spJenisCuti.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Menampilkan pilihan yang dipilih dari Spinner Jenis Cuti
                tvJenisCuti.text = "Jenis Cuti: ${jenisCutiOptions[position]}"
                tvJenisCuti.setTextColor(ContextCompat.getColor(this@PNSActivity, android.R.color.black))
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
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
}