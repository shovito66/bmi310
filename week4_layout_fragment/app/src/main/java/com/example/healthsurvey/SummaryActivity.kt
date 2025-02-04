package com.example.healthsurvey
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.GridView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.healthsurvey.databinding.ActivitySummaryBinding

class SummaryActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySummaryBinding
    private val TAG = "SummaryActivityLifecycle"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        logLifecycleEvent("SummaryActivity onCreate")

        // Retrieve data from Intent
        val name = intent.getStringExtra("personalInfoName") ?: "N/A"
        val age = intent.getStringExtra("personalInfoAge") ?: "N/A"
        val gender = intent.getStringExtra("personalInfoGender") ?: "N/A"
        val bp = intent.getStringExtra("healthBP") ?: "N/A"
        val weight = intent.getStringExtra("healthWeight") ?: "N/A"
        val height = intent.getStringExtra("healthHeight") ?: "N/A"

        // Prepare data for GridView
        val summaryData = listOf(
            "Name: $name",
            "Age: $age",
            "Gender: $gender",
            "Blood Pressure: $bp",
            "Weight: $weight",
            "Height: $height"
        )

        // Set up GridView with a Custom Adapter
        val adapter = SummaryAdapter(this, summaryData)
        binding.summaryGridView.adapter = adapter

        // Optional: Set item click listener
        binding.summaryGridView.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, summaryData[position], Toast.LENGTH_SHORT).show()
        }

        // Set Submit Button Click Listener
        binding.submitSummaryButton.setOnClickListener {
            // Implement desired functionality, e.g., navigate back to MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        logLifecycleEvent("SummaryActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        logLifecycleEvent("SummaryActivity onResume")
    }

    override fun onPause() {
        super.onPause()
        logLifecycleEvent("SummaryActivity onPause")
    }

    override fun onStop() {
        super.onStop()
        logLifecycleEvent("SummaryActivity onStop")
    }

    override fun onRestart() {
        super.onRestart()
        logLifecycleEvent("SummaryActivity onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        logLifecycleEvent("SummaryActivity onDestroy")
    }

    private fun logLifecycleEvent(event: String) {
        // Log to Logcat
        Log.d(TAG, event)

        // Update the TextView with the event
        binding.summaryLifecycleTextView.append("$event\n")
    }
}
