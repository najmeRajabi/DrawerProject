package com.example.drawerproject

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.drawerproject.databinding.FragmentEditProfileInfoBinding

class EditProfileInfoFragment : Fragment() {

    lateinit var binding: FragmentEditProfileInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditProfileInfoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegister.setOnClickListener {
            if (check()){
                saveInSharedPref()
                Toast.makeText(activity, "registered" , Toast.LENGTH_SHORT).show()
                activity?.onBackPressed()
            }
        }
    }
    private fun check(): Boolean {
        var  result = false
        when {
            binding.edtName.text.isNullOrBlank() -> {
                binding.edtName.error = "empty!"
            }
            binding.edtNationalCode.text.isNullOrBlank() -> {
                binding.edtNationalCode.error = "empty!"
            }
            binding.edtPhone.text.isNullOrBlank() -> {
                binding.edtPhone.error = "empty!"
            }
            binding.edtEmail.text.isNullOrBlank() -> {
                binding.edtEmail.error = "empty!"
            }
            else -> result= true
        }
        return result
    }

    private fun saveInSharedPref() {
        val sharedPreferences: SharedPreferences =
            requireActivity().getSharedPreferences("HW10" , Context.MODE_PRIVATE)
        sharedPreferences.edit().apply {
            clear()
            putString(NAME ,binding.edtName.text.toString())
            putString(NATIONAL ,binding.edtNationalCode.text.toString())
            putString(PHONE ,binding.edtPhone.text.toString())
            putString(IMAGE ,binding.edtEmail.text.toString())
            apply()
        }
    }


}