package com.demo.practice

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.demo.practice.activity_lifecycle.ActivityA
import com.demo.practice.databinding.ActivityMainBinding
import com.demo.practice.fragment_lifecycle.ActivityFragment
import com.demo.practice.networktest.NetworkCheckActivity

class MainActivity : AppCompatActivity() {

    private var _binding : ActivityMainBinding?= null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTestActivity.setOnClickListener {
            startActivity(Intent(this, ActivityA::class.java))
        }

        binding.btnTestFragment.setOnClickListener {
            startActivity(Intent(this, ActivityFragment::class.java))
        }

        binding.btnNetworkCheck.setOnClickListener {
            startActivity(Intent(this, NetworkCheckActivity::class.java))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}