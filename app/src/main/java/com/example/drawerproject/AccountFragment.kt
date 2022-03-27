package com.example.drawerproject

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.drawerproject.databinding.FragmentAccountBinding


class AccountFragment : Fragment() {

    lateinit var binding: FragmentAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAccountBinding.inflate(layoutInflater, container, false)
        initViews()
        return binding.root
    }

    fun initViews(){
        val sharedPreferences: SharedPreferences =
            requireActivity().getSharedPreferences("HW10" , Context.MODE_PRIVATE)
        sharedPreferences.apply {
            binding.txvAccountNum.text=getString(ACCOUNTNUM ,"")
            binding.txvCartNum.text= getString(CARTNUM ,"")
            binding.txvShebaNum.text=getString(SHEBANUM ,"")
        }
    }

}