package com.example.drawerproject

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
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
        checkAllow()
        val sharedPreferences: SharedPreferences =
            requireActivity().getSharedPreferences("HW10Profile" , Context.MODE_PRIVATE)
        sharedPreferences.apply {
            binding.txvName.text=getString(NAME ,"")
            binding.txvNationalCode.text= getString(NATIONAL ,"")
            binding.txvPhoneNumber.text=getString(PHONE ,"")

            val media= "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTkspTGDaYI0SloxfqGWTJMZYniyE8q9oqahw&usqp=CAU"
            glide(binding.imvProfile,media)
        }
    }

    private fun checkAllow() {
        if (!SHOWINFO){
            binding.llNotAllowedImv.visibility = View.VISIBLE
            binding.llInfoAccount.visibility = View.GONE
            Toast.makeText(activity, getString(R.string.dont_allowed), Toast.LENGTH_SHORT)
                .show()
        }
    }

    fun glide(imageview: ImageView, media:String){
        if (media !== null) {
            Glide.with(this)
                .load(media)
                .transform(CircleCrop())
                .placeholder(R.drawable.ic_baseline_more_horiz_24) //5
                .error(R.drawable.ic_baseline_image_not_supported_24) //6
                .into(imageview)
        }
    }

}