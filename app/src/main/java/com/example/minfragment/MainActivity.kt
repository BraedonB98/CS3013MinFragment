package com.example.minfragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.FragmentContainerView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun startFragment(view: View) {
        findViewById<FragmentContainerView>(R.id.fragment_container)?.let { frameLayout ->
            val blueFragment = BlueFragment.newInstance("FIRST")
            supportFragmentManager.beginTransaction()
                .replace(frameLayout.id, blueFragment)
                .addToBackStack(null)
                .commit()
        }
    }
}