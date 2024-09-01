package com.demo.practice.fragment_lifecycle

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.demo.practice.Constant.TAG
import com.demo.practice.databinding.FragmentBBinding

class FragmentB : Fragment() {

    private var _binding : FragmentBBinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "FragmentB onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "FragmentB onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(TAG, "FragmentB onCreateView")
        _binding = FragmentBBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "FragmentB onViewCreated")
        binding.btnFragmentA.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().apply {
                remove(this@FragmentB)
                commit()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "FragmentB onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "FragmentB onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "FragmentB onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "FragmentB onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "FragmentB onDestroy")
        _binding = null
    }
    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "FragmentB onDetach")
    }

}