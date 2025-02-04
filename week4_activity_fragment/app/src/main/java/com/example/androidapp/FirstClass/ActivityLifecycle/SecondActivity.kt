package com.example.androidapp.FirstClass.ActivityLifecycle

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidapp.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_second)

        val btnGoBack: Button = findViewById(R.id.btnGoBack)
        btnGoBack.setOnClickListener {
            finish() // Go back to MainActivity
        }

        Log.d("ActivityLifecycle", "SecondActivity: onCreate called")
        Toast.makeText(this, "SecondActivity: onCreate called", Toast.LENGTH_SHORT).show()

    }

    override fun onStart() {
        super.onStart()
        Log.d("ActivityLifecycle", "SecondActivity: onStart called")
        Toast.makeText(this, "SecondActivity: onStart called", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Log.d("ActivityLifecycle", "SecondActivity: onResume called")
        Toast.makeText(this, "SecondActivity: onResume called", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.d("ActivityLifecycle", "SecondActivity: onPause called")
        Toast.makeText(this, "SecondActivity: onPause called", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Log.d("ActivityLifecycle", "SecondActivity: onStop called")
        Toast.makeText(this, "SecondActivity: onStop called", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("ActivityLifecycle", "SecondActivity: onDestroy called")
        Toast.makeText(this, "SecondActivity: onDestroy called", Toast.LENGTH_SHORT).show()
    }
}