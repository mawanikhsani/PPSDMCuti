package com.example.ppsdmcuti.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.ppsdmcuti.R
import com.example.ppsdmcuti.fragment.HistoryFragment
import com.example.ppsdmcuti.fragment.HomeFragment
import com.example.ppsdmcuti.fragment.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener

private val BottomNavigationView.setOn: Unit
    get() {}

class HomeActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        loadFragment(HomeFragment())

        bottomNavigationView = findViewById(R.id.bottomNavigation)

        bottomNavigationView.setOn;OnItemSelectedListener {
            when (it.itemId){
                R.id.nav_home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.nav_history -> {
                    loadFragment(HistoryFragment())
                    true
                }
                R.id.nav_profile -> {
                    loadFragment(ProfileFragment())
                    true
                }
                else -> {
                    loadFragment(HomeFragment())'
                    true'
                }
            }
        }
    }

    private fun loadFragment(homeFragment: HomeFragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace((R.id.container, fragment))
        transaction.commit()
    }
}