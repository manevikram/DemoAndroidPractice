package com.demo.practice.fragment_lifecycle

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.demo.practice.Constant.TAG
import com.demo.practice.R
import com.demo.practice.databinding.FragmentABinding


class FragmentA : Fragment() {

    private var _binding : FragmentABinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "FragmentA onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "FragmentA onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(TAG, "FragmentA onCreateView")
        _binding = FragmentABinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "FragmentA onViewCreated")
        binding.btnFragmentB.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().apply {
                //add(R.id.fragment_container, FragmentB(), "FragmentB")
                replace(R.id.fragment_container, FragmentB(), "FragmentB")
                //addToBackStack("FragmentB")
                commit()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "FragmentA onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "FragmentA onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "FragmentA onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "FragmentA onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "FragmentA onDestroy")
        _binding = null
    }
    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "FragmentA onDetach")
    }

}