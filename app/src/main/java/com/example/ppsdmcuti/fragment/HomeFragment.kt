package com.example.ppsdmcuti.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.ppsdmcuti.R
import com.example.ppsdmcuti.activity.NonPnsActivity
import com.example.ppsdmcuti.activity.PNSActivity

class HomeFragment : Fragment() {

    private lateinit var btnPNS: Button
    private lateinit var btnNONPNS: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        btnPNS = view.findViewById(R.id.btnPNS)
        btnNONPNS = view.findViewById(R.id.btnNONPNS)

        btnPNS.setOnClickListener {
            val intent = Intent(activity, PNSActivity::class.java)
            startActivity(intent)
        }

        btnNONPNS.setOnClickListener {
            val intent = Intent(activity, NonPnsActivity::class.java)
            startActivity(intent)
        }

        return view
    }
}