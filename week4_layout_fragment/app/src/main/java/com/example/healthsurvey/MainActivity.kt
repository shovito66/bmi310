package com.example.healthsurvey
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var lifecycleTextView: TextView
    private lateinit var startSurveyButton: Button

    // Tag for logging
    private val TAG = "MainActivityLifecycle"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        lifecycleTextView = findViewById(R.id.lifecycleTextView)
        startSurveyButton = findViewById(R.id.startSurveyButton)

        logLifecycleEvent("onCreate")

        // Set click listener to start survey
        startSurveyButton.setOnClickListener {
            val intent: Intent = Intent(this, SurveyActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        logLifecycleEvent("onStart")
    }

    override fun onResume() {
        super.onResume()
        logLifecycleEvent("onResume")
    }

    override fun onPause() {
        super.onPause()
        logLifecycleEvent("onPause")
    }

    override fun onStop() {
        super.onStop()
        logLifecycleEvent("onStop")
    }

    override fun onRestart() {
        super.onRestart()
        logLifecycleEvent("onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        logLifecycleEvent("onDestroy")
    }


    private fun logLifecycleEvent(event: String) {
        // Log to Logcat
        Log.d(TAG, event)

        // Update the TextView with the event
        lifecycleTextView.append("$event\n")
    }
}
