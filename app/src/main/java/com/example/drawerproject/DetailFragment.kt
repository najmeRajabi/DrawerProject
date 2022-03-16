package com.example.drawerproject


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imvIcon.setOnClickListener {
            Toast.makeText(activity,"share" , Toast.LENGTH_SHORT).show()
        }
    }

//    private fun share() {
//        val intent = Intent(activity, Intent.ACTION_SEND)
//        startActivity(intent)
//    }

}