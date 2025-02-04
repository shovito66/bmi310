package com.example.androidapp.FirstClass

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidapp.R

class FragmentLifecycle : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_fragment_lifecycle)
        val openFragment = findViewById<Button>(R.id.button3)
        openFragment.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, Fragment1())
                .commit()
        }
    }
}