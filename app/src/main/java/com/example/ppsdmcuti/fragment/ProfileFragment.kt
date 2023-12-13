package com.example.ppsdmcuti.fragment

import android.app.Activity
import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.cardview.widget.CardView
import com.example.ppsdmcuti.R
import com.example.ppsdmcuti.activity.LoginActivity
import de.hdodenhof.circleimageview.CircleImageView
import java.io.File
import java.io.FileOutputStream
import android.graphics.Bitmap
import java.io.InputStream

class ProfileFragment : Fragment() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var ivProfileUser: CircleImageView
    private lateinit var btnUbahFoto: ImageButton
    private lateinit var selectedImageFile: File


    private val PICK_IMAGE_REQUEST = 1


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        ivProfileUser = view.findViewById(R.id.ivProfileUser)
        btnUbahFoto = view.findViewById(R.id.btnUbahFoto)

        selectedImageFile = File(requireContext().cacheDir, "selected_image.jpg")

        if (selectedImageFile.exists()) {
            // Jika gambar telah dipilih sebelumnya, tampilkan di ivProfileUser
            val bitmap = BitmapFactory.decodeFile(selectedImageFile.absolutePath)
            ivProfileUser.setImageBitmap(bitmap)
        }

        // Menangani klik pada btnUbahFoto
        btnUbahFoto.setOnClickListener {
            // Memulai aktivitas pemilihan gambar dari galeri
            openGalleryForImage()
        }


        sharedPreferences =
            requireContext().getSharedPreferences("loginPrefs", Context.MODE_PRIVATE)

        val btnLogOut: CardView = view.findViewById(R.id.btnLogOut)

        btnLogOut.setOnClickListener {
            // Hapus status login dari SharedPreferences
            val editor = sharedPreferences.edit()
            editor.putBoolean("isLoggedIn", false)
            editor.apply()

            val intent = Intent(requireContext(), LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            requireActivity().finish()
        }

        return view

//        // Load saved image URI
//        val imageUriString = sharedPreferences.getString("imageUri", null)
//        if (imageUriString != null) {
//            val imageUri = Uri.parse(imageUriString)
//            ivProfileUser.setImageURI(imageUri)
//        }
//
//        ivUbahFoto.setOnClickListener {
//            // Membuka galeri untuk memilih gambar
//            val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
//            startActivityForResult(galleryIntent, PICK_IMAGE_REQUEST)
//        }
//
//        return view
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
//            // Mendapatkan URI gambar yang dipilih dari galeri
//            val imageUri: Uri = data.data!!
//
//            // Menyimpan URI gambar ke SharedPreferences
//            val editor = sharedPreferences.edit()
//            editor.putString("imageUri", imageUri.toString())
//            editor.apply()
//
//            // Menampilkan gambar pada ImageView
//            ivProfileUser.setImageURI(imageUri)
//        }
//    }
    }

    // Contract untuk memilih gambar dari galeri
    private val getContent =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                // Mengambil gambar yang dipilih dari intent
                val selectedImageUri = result.data?.data
                selectedImageUri?.let { uri ->
                    // Menampilkan gambar di ivProfileUser
                    ivProfileUser.setImageURI(uri)

                    // Menyimpan gambar ke file untuk penggunaan selanjutnya
                    //saveImageToFile(uri)
                }
            }
        }

    // Fungsi untuk membuka galeri
    private fun openGalleryForImage() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        getContent.launch(intent)
    }


//    // Fungsi untuk menyimpan gambar ke file
//
//    private fun saveImageToFile(uri: android.net.Uri) {
//        try {
//            val inputStream: InputStream? = contentResolver.openInputStream(uri)
//            val outputStream = FileOutputStream(selectedImageFile)
//            val buffer = ByteArray(1024)
//            var bytesRead: Int
//
//            bytesRead = inputStream?.read(buffer) ?: 0
//
//            while (bytesRead != -1) {
//                outputStream.write(buffer, 0, bytesRead)
//                bytesRead = inputStream?.read(buffer) ?: 0
//            }
//
//            inputStream?.close()
//            outputStream.close()
//        } catch (e: Exception) {
//            Log.e("ProfileActivity", "Error saving image to file: ${e.message}")
//        }
//    }

}
