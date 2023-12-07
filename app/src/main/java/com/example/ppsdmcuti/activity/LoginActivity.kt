package com.example.ppsdmcuti.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.ppsdmcuti.R
import com.example.ppsdmcuti.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etPass : EditText
    private lateinit var btnLogin : Button

    private lateinit var sharedPreferences: SharedPreferences

    private val dummyEmail = "ppsdm@gmail.com"
    private val dummyPassword = "pass123"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etEmail = findViewById(R.id.etEmail)
        etPass = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)

        sharedPreferences = getSharedPreferences("loginPrefs", Context.MODE_PRIVATE)

        if (sharedPreferences.getBoolean("isLoggedIn", false)) {
            // Jika sudah login, pindah ke HomeActivity
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnLogin.setOnClickListener {
            loginUser()
        }
    }

    private fun loginUser() {
        val email = etEmail.text.toString().trim()
        val password = etPass.text.toString().trim()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Silahkan masukkan email dan password", Toast.LENGTH_SHORT).show()

        } else {
            if (email == dummyEmail && password == dummyPassword) {
                // Simpan status login ke SharedPreferences
                val editor = sharedPreferences.edit()
                editor.putBoolean("isLoggedIn", true)
                editor.apply()

                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Login gagal. Periksa kembali email dan password Anda.", Toast.LENGTH_SHORT).show()
            }
        }
    }

}