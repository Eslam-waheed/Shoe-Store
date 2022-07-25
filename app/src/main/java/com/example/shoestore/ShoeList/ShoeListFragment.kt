package com.example.shoestore.ShoeList

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.ShoeListViewModel
import com.example.shoestore.databinding.FragmentShoeListBinding
import com.example.shoestore.modeks.Shoe

class ShoeListFragment : Fragment() {

    private lateinit var viewModel: ShoeListViewModel
    private lateinit var binding: FragmentShoeListBinding
    private lateinit var shoe: Shoe
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)
        if (viewModel.state) {
            shoe = Shoe(
                viewModel.shoeName.value!!, viewModel.sizeName.value!!,
                viewModel.company.value!!, viewModel.description.value!!
            )
            viewModel.addNewShoe(shoe)
            viewModel.state = false
        }
        viewModel.shoeList.observe(requireActivity(), Observer {
            for (shoe in it) {
                addView(shoe)
            }
        })

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailsFragment)
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    private fun addView(item: Shoe) {
        val shoes = ("Shoe Name: " + item.name + "\n"
                + "Shoe Size: " + item.size + "\n"
                + "Company Name: " + item.company + "\n"
                + "Description: " + item.description + "\n")

        val textview = TextView(context)
        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        textview.layoutParams = params
        textview.textSize = 20f

        textview.text = shoes
        binding.shoeListView.addView(textview)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logoutItem -> {
                findNavController().navigate(R.id.action_shoeListFragment_to_logInFragment)
            }
        }
        return true
    }
}