package com.demo.practice.activity_lifecycle

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.demo.practice.Constant.TAG
import com.demo.practice.databinding.ActivityBBinding

class ActivityB : AppCompatActivity() {

    private var _binding : ActivityBBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"ActivityB - onCreate")
        _binding = ActivityBBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGoBackToActivityA.setOnClickListener {
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"ActivityB - onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG,"ActivityB - onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"ActivityB - onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"ActivityB - onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"ActivityB - onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"ActivityB - onDestroy")
        _binding = null
    }
}