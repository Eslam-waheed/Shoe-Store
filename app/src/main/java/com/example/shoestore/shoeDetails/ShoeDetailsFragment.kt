package com.example.shoestore.shoeDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.ShoeListViewModel
import com.example.shoestore.databinding.FragmentShoeDetailsBinding

class ShoeDetailsFragment : Fragment() {

    private lateinit var viewModel: ShoeListViewModel
    private lateinit var binding: FragmentShoeDetailsBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_details, container, false
        )

        viewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)
        binding.shoe = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.saveButton.setOnClickListener {
            viewModel.state = true
            if ((binding.shoeNameEditText.text.toString().isEmpty())
                || (binding.companyNameEditText.text.toString().isEmpty())
                || (binding.shoeSizeEditText.text.toString().isEmpty())
                || (binding.descriptionEditText.text.toString().isEmpty())
            ) {
                Toast.makeText(context, "Please enter all data", Toast.LENGTH_SHORT).show()
            } else {
                findNavController().navigate(R.id.action_shoeDetailsFragment_to_shoeListFragment)
            }
        }
        binding.cancelButton.setOnClickListener {
            findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment())
        }
        return binding.root
    }
}