package com.example.drawerproject

import android.os.Bundle
import android.view.*
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.drawerproject.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private val infoViewModel:InfoViewModel by activityViewModels()

    lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)


        setHasOptionsMenu(true)


        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val arrayBox= arrayListOf(binding.includeImg1,
            binding.includeImg2, binding.includeImg3,
            binding.includeImg4, binding.includeImg5,
            binding.includeImg6)


        for (i in 0 until NUMBER){
            arrayBox[i].imvHome.setOnClickListener {
                val bundle = bundleOf("index" to i)
                findNavController().navigate(R.id.action_homeFragment_to_detailFragment , bundle)
            }

            arrayBox[i].textView.text = infoViewModel.getName(i)
            infoViewModel.getImageUrl(i)?.let { glide(arrayBox[i].imvHome , it) }

        }

    }
    fun glide(imageview:ImageView , media:String){
        if (media !== null) {
            Glide.with(this)
                .load(media)
                .transform(CircleCrop())
                .placeholder(R.drawable.ic_baseline_more_horiz_24) //5
                .error(R.drawable.ic_baseline_image_not_supported_24) //6
                .into(imageview)
        }
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.home_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
        val item = menu.findItem(R.id.accountFragment)
        item.isVisible = true
    }


}