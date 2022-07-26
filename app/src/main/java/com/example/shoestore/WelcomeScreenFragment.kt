package com.example.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.shoestore.databinding.FragmentWelcomeScreenBinding

class WelcomeScreenFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentWelcomeScreenBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_welcome_screen, container, false)

        binding.welcomeButton.setOnClickListener {
            findNavController().navigate(WelcomeScreenFragmentDirections.actionWelcomeScreenFragmentToInstructionScreenFragment())
        }
        return binding.root
    }
}