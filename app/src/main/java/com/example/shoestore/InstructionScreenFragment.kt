package com.example.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.shoestore.databinding.FragmentInstructionScreenBinding

class InstructionScreenFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentInstructionScreenBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_instruction_screen, container, false)

        binding.instructionButton.setOnClickListener {
            findNavController().navigate(InstructionScreenFragmentDirections.actionInstructionScreenFragmentToShoeListFragment())
        }
        return binding.root
    }
}