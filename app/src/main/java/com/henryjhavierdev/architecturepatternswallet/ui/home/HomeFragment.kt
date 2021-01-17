package com.henryjhavierdev.architecturepatternswallet.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.henryjhavierdev.architecturepatternswallet.databinding.FragmentHomeBinding
import com.henryjhavierdev.architecturepatternswallet.viewmodel.HomeViewModel

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?
    ): View? {

        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)

        binding = FragmentHomeBinding.inflate(inflater, container, false)


        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.tvHome.text = it
        })


        return binding.root

    }

}