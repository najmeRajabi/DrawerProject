package com.example.drawerproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
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




        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val arrayBox= arrayListOf(binding.includeImg1,
            binding.includeImg2, binding.includeImg3,
            binding.includeImg4, binding.includeImg5,
            binding.includeImg6)

        val itemList = infoViewModel.arrayInfo

        for (i in 0 until NUMBER){
            arrayBox[i].imvHome.setOnClickListener {
                val bundle = bundleOf("index" to i)
                findNavController().navigate(R.id.action_homeFragment_to_detailFragment , bundle)
            }
            arrayBox[i].textView.text = itemList[i].name
            glide(arrayBox[i].imvHome,itemList[i].image)

        }

    }
    fun glide(imageview:ImageView , media:String){
//        val media = "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_960_720.jpg"
        if (media !== null) {
            Glide.with(this)
                .load(media)
                .transform(CircleCrop())
                .placeholder(R.drawable.ic_baseline_more_horiz_24) //5
                .error(R.drawable.ic_baseline_image_not_supported_24) //6
                .into(imageview)
//                .fallback(R.drawable.ic_no_image) //7
//                .transform(CircleCrop())
//                .centerCrop()


        }
    }

}