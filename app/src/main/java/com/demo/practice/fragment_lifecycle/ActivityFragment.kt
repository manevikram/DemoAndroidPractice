package com.demo.practice.fragment_lifecycle

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.demo.practice.Constant.TAG
import com.demo.practice.R
import com.demo.practice.databinding.ActivityFragmentBinding

class ActivityFragment : AppCompatActivity() {

    private var _binding : ActivityFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "ActivityFragment onCreate")
        _binding = ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFragmentA.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                //add(R.id.fragment_container, FragmentA(), "FragmentA")
                replace(R.id.fragment_container, FragmentA(), "FragmentA")
                //addToBackStack("FragmentA")
                commit()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "ActivityFragment onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "ActivityFragment onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "ActivityFragment onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "ActivityFragment onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "ActivityFragment onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "ActivityFragment onDestroy")
        _binding = null
    }
}