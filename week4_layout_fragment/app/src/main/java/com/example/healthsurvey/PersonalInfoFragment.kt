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

class PersonalInfoFragment : Fragment(R.layout.fragment_personal_info) {

    private val TAG = "PersonalInfoFragLifecycle"

    private lateinit var nameTextView: TextView
    private lateinit var ageTextView: TextView
    private lateinit var genderTextView: TextView

    private lateinit var viewModel: SurveyViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        logFragmentLifecycleEvent("PersonalInfoFragment", "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logFragmentLifecycleEvent("PersonalInfoFragment", "onCreate")
        viewModel = ViewModelProvider(requireActivity()).get(SurveyViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        logFragmentLifecycleEvent("PersonalInfoFragment", "onCreateView")
        return inflater.inflate(R.layout.fragment_personal_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logFragmentLifecycleEvent("PersonalInfoFragment", "onViewCreated")

        nameTextView = view.findViewById(R.id.nameTextView)
        ageTextView = view.findViewById(R.id.ageTextView)
        genderTextView = view.findViewById(R.id.genderTextView)

        viewModel.personalInfo.observe(viewLifecycleOwner, { info ->
            nameTextView.text = "Name: ${info.name}"
            ageTextView.text = "Age: ${info.age}"
            genderTextView.text = "Gender: ${info.gender}"
        })
    }

    override fun onStart() {
        super.onStart()
        logFragmentLifecycleEvent("PersonalInfoFragment", "onStart")
    }

    override fun onResume() {
        super.onResume()
        logFragmentLifecycleEvent("PersonalInfoFragment", "onResume")
    }

    override fun onPause() {
        super.onPause()
        logFragmentLifecycleEvent("PersonalInfoFragment", "onPause")
    }

    override fun onStop() {
        super.onStop()
        logFragmentLifecycleEvent("PersonalInfoFragment", "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        logFragmentLifecycleEvent("PersonalInfoFragment", "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        logFragmentLifecycleEvent("PersonalInfoFragment", "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        logFragmentLifecycleEvent("PersonalInfoFragment", "onDetach")
    }

    private fun logFragmentLifecycleEvent(fragmentName: String, event: String) {
        // Log to Logcat
        Log.d(TAG, "$fragmentName $event")

        // Communicate to SurveyActivity
        (activity as? SurveyActivity)?.logFragmentLifecycleEvent(fragmentName, event)
    }
}
