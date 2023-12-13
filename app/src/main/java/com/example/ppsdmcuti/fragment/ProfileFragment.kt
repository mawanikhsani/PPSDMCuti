package com.example.ppsdmcuti.fragment

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import com.example.ppsdmcuti.R
import com.example.ppsdmcuti.activity.LoginActivity
import de.hdodenhof.circleimageview.CircleImageView

class ProfileFragment : Fragment() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var ivProfileUser: CircleImageView
    private lateinit var ivUbahFoto: ImageView

    private val PICK_IMAGE_REQUEST = 1


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        ivProfileUser = view.findViewById(R.id.ivProfileUser)
        ivUbahFoto = view.findViewById(R.id.ivUbahFoto)

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
}
