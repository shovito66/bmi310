package com.example.healthsurvey
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider


class HealthIndicatorsFragment : Fragment(R.layout.fragment_health_indicators) {

    // For logging fragment lifecycle events
    private val TAG = "HealthIndicatorsFragLifecycle"

    // UI components to display health indicators data
    private lateinit var bpTextView: TextView
    private lateinit var weightTextView: TextView
    private lateinit var heightTextView: TextView

    // To share data between fragments and activity
    private lateinit var viewModel: SurveyViewModel


    override fun onAttach(context: Context) {
        super.onAttach(context)
        logFragmentLifecycleEvent("HealthIndicatorsFragment", "onAttach")
    }

    // Called during the  initial creation of the fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logFragmentLifecycleEvent("HealthIndicatorsFragment", "onCreate")

        viewModel = ViewModelProvider(requireActivity()).get(SurveyViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        logFragmentLifecycleEvent("HealthIndicatorsFragment", "onCreateView")
        return inflater.inflate(R.layout.fragment_health_indicators, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logFragmentLifecycleEvent("HealthIndicatorsFragment", "onViewCreated")

        // Initialize TextViews by finding them in the inflated layout
        bpTextView = view.findViewById(R.id.bpTextView)
        weightTextView = view.findViewById(R.id.weightTextView)
        heightTextView = view.findViewById(R.id.heightTextView)

        // Observe changes in health indicators from the ViewModel
        viewModel.healthIndicators.observe(viewLifecycleOwner, { indicators ->
            // Update UI components with the latest health indicators
            bpTextView.text = "Blood Pressure: ${indicators.bloodPressure}"
            weightTextView.text = "Weight: ${indicators.weight}"
            heightTextView.text = "Height: ${indicators.height}"
        })
    }


    override fun onStart() {
        super.onStart()
        logFragmentLifecycleEvent("HealthIndicatorsFragment", "onStart")
    }


    override fun onResume() {
        super.onResume()
        logFragmentLifecycleEvent("HealthIndicatorsFragment", "onResume")
    }


    override fun onPause() {
        super.onPause()
        logFragmentLifecycleEvent("HealthIndicatorsFragment", "onPause")
    }


    override fun onStop() {
        super.onStop()
        logFragmentLifecycleEvent("HealthIndicatorsFragment", "onStop")
    }


    override fun onDestroyView() {
        super.onDestroyView()
        logFragmentLifecycleEvent("HealthIndicatorsFragment", "onDestroyView")
    }


    override fun onDestroy() {
        super.onDestroy()
        logFragmentLifecycleEvent("HealthIndicatorsFragment", "onDestroy")
    }


    override fun onDetach() {
        super.onDetach()
        logFragmentLifecycleEvent("HealthIndicatorsFragment", "onDetach")
    }


    private fun logFragmentLifecycleEvent(fragmentName: String, event: String) {
        Log.d(TAG, "$fragmentName $event")
        (activity as? SurveyActivity)?.logFragmentLifecycleEvent(fragmentName, event)
    }
}
