package com.example.drawerproject


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
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


        glide(binding.imvDetail,infoViewModel.arrayInfo[index].image)



        return binding .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val index = requireArguments().getInt("index")

        binding.imvIcon.setOnClickListener {
            Toast.makeText(activity,"share" , Toast.LENGTH_SHORT).show()
            share(infoViewModel.arrayInfo[index].name)
        }
    }

    private fun share(message: String) {

        val intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, message)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(intent, null)
        startActivity(shareIntent)

    }

    fun glide(imageview: ImageView, media:String){

        if (media !== null) {
            Glide.with(this)
                .load(media)
//                .transform(CircleCrop())
                .placeholder(R.drawable.ic_baseline_more_horiz_24) //5
                .error(R.drawable.ic_baseline_image_not_supported_24) //6
                .into(imageview)
//                .fallback(R.drawable.ic_no_image) //7
//                .transform(CircleCrop())
//                .centerCrop()


        }
    }

}