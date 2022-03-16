package com.example.drawerproject

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.drawerproject.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {


    lateinit var binding :FragmentProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)

        initViews()
        return binding.root
    }

    private fun initViews() {
        val sharedPreferences: SharedPreferences =
            requireActivity().getSharedPreferences("HW10" , Context.MODE_PRIVATE)
        sharedPreferences.apply {
            binding.txvName.text=getString(NAME ,"")
            binding.txvNationalCode.text= getString(NATIONAL ,"")
            binding.txvPhoneNumber.text=getString(PHONE ,"")
        }
    }

}