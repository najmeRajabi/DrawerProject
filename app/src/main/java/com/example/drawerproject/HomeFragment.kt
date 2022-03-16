package com.example.drawerproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.drawerproject.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    val infoViewModel:InfoViewModel by viewModels()

    lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        val arrayBox= arrayListOf(binding.includeImg1,
        binding.includeImg2, binding.includeImg3,
        binding.includeImg4, binding.includeImg5,
            binding.includeImg6)

        val itemList = infoViewModel.arrayInfo


        return binding.root
    }



}