package com.example.androidapp.FirstClass

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.androidapp.R


class Fragment1 : Fragment() {


    override fun onDestroy() {
        super.onDestroy()
        Log.d("FragmentLifecycle", "onDestroy called")
        Toast.makeText(requireContext(), "onDestroy called", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("FragmentLifecycle", "onCreate called")
        Toast.makeText(requireContext(), "onCreate called", Toast.LENGTH_SHORT).show()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("FragmentLifecycle", "onCreateView called")
        Toast.makeText(requireContext(), "onCreateView called", Toast.LENGTH_SHORT).show()
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false)
    }

    override fun onStop() {
        super.onStop()
        Log.d("FragmentLifecycle", "onStop called")
        Toast.makeText(requireContext(), "onStop called", Toast.LENGTH_SHORT).show()
    }



    override fun onStart() {
        super.onStart()
        Log.d("FragmentLifecycle", "onStart called")
        Toast.makeText(requireContext(), "onStart called", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Log.d("FragmentLifecycle", "onResume called")
        Toast.makeText(requireContext(), "onResume called", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.d("FragmentLifecycle", "onPause called")
        Toast.makeText(requireContext(), "onPause called", Toast.LENGTH_SHORT).show()

    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toast.makeText(requireContext(), "onViewCreated called", Toast.LENGTH_SHORT).show()
        Log.d("FragmentLifecycle", "onViewCreated called")
    }




}