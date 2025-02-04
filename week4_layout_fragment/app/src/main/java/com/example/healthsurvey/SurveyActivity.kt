package com.example.healthsurvey
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class SurveyActivity : AppCompatActivity() {

    private lateinit var surveyLifecycleTextView: TextView
    private lateinit var nextButton: Button
    private lateinit var previousButton: Button

    private var currentSection = 1
    private val TAG = "SurveyActivityLifecycle"

    private lateinit var viewModel: SurveyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey)

        // Initialization of  ViewModel
        viewModel = ViewModelProvider(this).get(SurveyViewModel::class.java)

        // Initialization views
        surveyLifecycleTextView = findViewById(R.id.surveyLifecycleTextView)
        nextButton = findViewById(R.id.nextButton)
        previousButton = findViewById(R.id.previousButton)

        logLifecycleEvent("SurveyActivity onCreate")

        // Loading first fragment (PersonalInfo)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, PersonalInfoFragment())
                .commit()
            logLifecycleEvent("Loaded PersonalInfoFragment")
        }

        // For navigation buttons
        nextButton.setOnClickListener {
            when (currentSection) {
                1 -> {
                    // Navigates to HealthIndicatorsFragment
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, HealthIndicatorsFragment())
                        .commit()
                    logLifecycleEvent("Swapped to HealthIndicatorsFragment")
                    currentSection = 2
                    nextButton.text = "Finish Survey"
                    previousButton.isEnabled = true
                }
                2 -> {
                    // Navigates to SummaryActivity
                    val intent = Intent(this, SummaryActivity::class.java).apply {
                        putExtra("personalInfoName", viewModel.personalInfo.value?.name)
                        putExtra("personalInfoAge", viewModel.personalInfo.value?.age)
                        putExtra("personalInfoGender", viewModel.personalInfo.value?.gender)
                        putExtra("healthBP", viewModel.healthIndicators.value?.bloodPressure)
                        putExtra("healthWeight", viewModel.healthIndicators.value?.weight)
                        putExtra("healthHeight", viewModel.healthIndicators.value?.height)
                    }
                    startActivity(intent)
                    logLifecycleEvent("Navigated to SummaryActivity")
                    finish()
                }
            }
        }

        previousButton.setOnClickListener {
            when (currentSection) {
                2 -> {
                    // Navigate back to PersonalInfoFragment
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, PersonalInfoFragment())
                        .commit()
                    logLifecycleEvent("Swapped to PersonalInfoFragment")
                    currentSection = 1
                    nextButton.text = "Next"
                    previousButton.isEnabled = false
                }
            }
        }

        // Initially previous button is disabled
        previousButton.isEnabled = false
    }

    override fun onStart() {
        super.onStart()
        logLifecycleEvent("SurveyActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        logLifecycleEvent("SurveyActivity onResume")
    }

    override fun onPause() {
        super.onPause()
        logLifecycleEvent("SurveyActivity onPause")
    }

    override fun onStop() {
        super.onStop()
        logLifecycleEvent("SurveyActivity onStop")
    }

    override fun onRestart() {
        super.onRestart()
        logLifecycleEvent("SurveyActivity onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        logLifecycleEvent("SurveyActivity onDestroy")
    }


    fun logLifecycleEvent(event: String) {
        // Log to Logcat
        Log.d(TAG, event)

        // Update the TextView with the event
        surveyLifecycleTextView.append("$event\n")
    }

    fun logFragmentLifecycleEvent(fragmentName: String, event: String) {
        val message = "$fragmentName $event"
        Log.d(TAG, message)
        surveyLifecycleTextView.append("$message\n")
    }
}
