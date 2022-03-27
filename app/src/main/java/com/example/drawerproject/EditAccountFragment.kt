package com.example.drawerproject

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.drawerproject.databinding.FragmentEditAccountBinding

class EditAccountFragment : Fragment() {

    lateinit var binding: FragmentEditAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditAccountBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSaveAccountInfo.setOnClickListener {
            if (checkEditTexts()) {
                saveAccountInfo()
                activity?.onBackPressed()
            }
        }
    }

    private fun saveAccountInfo() {
        Toast.makeText(activity, "saved", Toast.LENGTH_SHORT).show()


        val sharedPreferences: SharedPreferences =
            requireActivity().getSharedPreferences("HW10", Context.MODE_PRIVATE)
        sharedPreferences.edit().apply {
            clear()
            putString(ACCOUNTNUM, binding.edtAccountNum.text.toString())
            putString(CARTNUM, binding.edtCartNum.text.toString())
            putString(SHEBANUM, binding.edtShebaNum.text.toString())
            apply()
        }


    }

    private fun checkEditTexts(): Boolean {
        var result = false
        when {
            binding.edtAccountNum.text.isNullOrBlank() -> {
                binding.edtAccountNum.error = getString(R.string.enter_account_num)
            }
            binding.edtCartNum.text.isNullOrBlank() -> {
                binding.edtCartNum.error = getString(R.string.enter_account_num)
            }
            binding.edtShebaNum.text.isNullOrBlank() -> {
                binding.edtShebaNum.error = getString(R.string.enter_account_num)
            }
            else -> {
                result = true
            }
        }

        return result
    }


}