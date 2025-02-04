package com.example.androidapp.FirstClass.ActivityLifecycle

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main2)

        val btnGoToSecondActivity: Button = findViewById(R.id.btnGoToSecondActivity)
        btnGoToSecondActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        Log.d("ActivityLifecycle", "MainActivity: onCreate called")
        Toast.makeText(this, "MainActivity: onCreate called", Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        Log.d("ActivityLifecycle", "MainActivity: onStart called")
        Toast.makeText(this, "MainActivity: onStart called", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Log.d("ActivityLifecycle", "MainActivity: onResume called")
        Toast.makeText(this, "MainActivity: onResume called", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.d("ActivityLifecycle", "MainActivity: onPause called")
        Toast.makeText(this, "MainActivity: onPause called", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Log.d("ActivityLifecycle", "MainActivity: onStop called")
        Toast.makeText(this, "MainActivity: onStop called", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("ActivityLifecycle", "MainActivity: onDestroy called")
        Toast.makeText(this, "MainActivity: onDestroy called", Toast.LENGTH_SHORT).show()
    }
}