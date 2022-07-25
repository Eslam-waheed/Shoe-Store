package com.example.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.shoestore.databinding.FragmentLogInBinding

class LogInFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle? ): View {
        val binding : FragmentLogInBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_log_in,container,false )

        binding.btnLogin.setOnClickListener{
            findNavController().navigate(R.id.action_logInFragment_to_welcomeScreenFragment)
        }
        binding.btnCreateAccount.setOnClickListener{
            findNavController().navigate(R.id.action_logInFragment_to_welcomeScreenFragment)
        }
        return binding.root
    }
}