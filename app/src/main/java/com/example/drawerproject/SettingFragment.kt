package com.example.drawerproject

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.SeekBar
import com.example.drawerproject.databinding.FragmentSettingBinding

var NUMBER= 4
var NAME = "name"
var NATIONAL = "nationalCode"
var PHONE = "phone"
var IMAGE = "image"

class SettingFragment : Fragment() {

    lateinit var binding: FragmentSettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.radioGroupTheme.setOnCheckedChangeListener{}
        checkRegistered()

        binding.radioGroupTheme.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { group, checkedId ->
                val radio: RadioButton? = activity?.findViewById(checkedId)
                changeTheme(binding.radioGroupTheme.checkedRadioButtonId)
                activity?.changingConfigurations
                activity?.recreate()
            })

        binding.btnRegister.setOnClickListener {
            if (check()){
                saveInSheardPref()
                changeVisibilityRegister()
                showInTxv()
            }
        }
        binding.btnChangeInfo.setOnClickListener {
            changeVisibility()
        }

        binding.txvSeekbar.text= NUMBER.toString()

        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                if (p0 != null) {
                    NUMBER = p0.progress
                    binding.txvSeekbar.text= NUMBER.toString()
                }
            }
        })
    }

    private fun changeTheme(id:Int): RadioGroup.OnCheckedChangeListener? {
        when (id){
            R.id.radioBtn_pink -> activity?.setTheme(R.style.Theme_Pink)
            R.id.radioBtn_blue -> activity?.setTheme(R.style.Theme_DrawerProject)
            R.id.radioBtn_dark -> activity?.setTheme(R.style.Theme_DrawerProject_dark)
        }
        return null
    }

    private fun checkRegistered() {
        val sharedPreferences:SharedPreferences =
            requireActivity().getSharedPreferences("HW10" , Context.MODE_PRIVATE)
        if (!sharedPreferences.getString(NAME,"").isNullOrBlank()){
            changeVisibilityRegister()
            showInTxv()
        }
    }

    private fun changeVisibility() {
        binding.llEdt.visibility= View.VISIBLE
        binding.llTxv.visibility= View.GONE
    }


    private fun showInTxv() {

        val sharedPreferences:SharedPreferences =
            requireActivity().getSharedPreferences("HW10" , Context.MODE_PRIVATE)
        sharedPreferences.apply {
            binding.txvNameS.text=getString(NAME ,"")
            binding.txvNationalCodeS.text= getString(NATIONAL ,"")
            binding.txvPhoneS.text=getString(PHONE ,"")
        }

    }

    private fun changeVisibilityRegister() {
        binding.llEdt.visibility= View.GONE
        binding.llTxv.visibility= View.VISIBLE
    }

    private fun saveInSheardPref() {
        val sharedPreferences:SharedPreferences =
            requireActivity().getSharedPreferences("HW10" , Context.MODE_PRIVATE)
        sharedPreferences.edit().apply {
            clear()
            putString(NAME ,binding.edtName.text.toString())
            putString(NATIONAL ,binding.edtNationalCode.text.toString())
            putString(PHONE ,binding.edtPhone.text.toString())
            putString(IMAGE ,binding.edtPhoto.text.toString())
            apply()
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
            binding.edtPhoto.text.isNullOrBlank() -> {
                binding.edtPhoto.error = "empty!"
            }
            else -> result= true
        }
        return result
    }


}