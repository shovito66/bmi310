package com.example.recyclerview.Binding

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.recyclerview.R
import com.example.recyclerview.databinding.ActivityMain3Binding


//same as layout/activity_main.xml but in binding we dont need to use findViewById
// we can directly access the views

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMain3Binding  // View Binding setup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main3)
        // Initialize binding
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Using binding to access views directly
        binding.buttonClick.setOnClickListener {
            binding.textView.text = "Button Clicked!"
            Toast.makeText(this, "Button Clicked!", Toast.LENGTH_SHORT).show()

        }
    }
}