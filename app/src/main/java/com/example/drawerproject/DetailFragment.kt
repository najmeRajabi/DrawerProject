package com.example.drawerproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.drawerproject.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    val infoViewModel: InfoViewModel by viewModels()
    lateinit var binding : FragmentDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater, container , false)

        val index = requireArguments().getInt("index")

        binding.txvNameDetail.text = infoViewModel.arrayInfo[index].name
        binding.txvExplainDetail.text = infoViewModel.arrayInfo[index].explain



        return binding .root
    }


}