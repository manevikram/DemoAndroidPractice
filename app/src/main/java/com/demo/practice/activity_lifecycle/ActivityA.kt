package com.demo.practice.activity_lifecycle

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.demo.practice.Constant.TAG
import com.demo.practice.databinding.ActivityABinding

class ActivityA : AppCompatActivity() {

    private var _binding : ActivityABinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"ActivityA - onCreate")
        _binding = ActivityABinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGoToActivityB.setOnClickListener {
            startActivity(Intent(this, ActivityB::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"ActivityA - onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG,"ActivityA - onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"ActivityA - onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"ActivityA - onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"ActivityA - onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"ActivityA - onDestroy")
        _binding = null
    }
}