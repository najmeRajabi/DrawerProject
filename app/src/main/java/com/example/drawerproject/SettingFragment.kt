package com.example.drawerproject

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.fragment.findNavController
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


            })
        binding.btnChangeAccountInfo.setOnClickListener {
            findNavController().navigate(R.id.action_settingFragment_to_editAccountFragment)
        }

        binding.btnChangeProfileInfo.setOnClickListener {
            findNavController().navigate(R.id.action_settingFragment_to_editProfileInfoFragment)
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

        }
    }





    fun onRadioButtonClick(view: View){
        if (view is RadioButton){
            val checked = view.isChecked
            when (view.getId()) {
                R.id.radioBtn_dark ->
                    if (checked) {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    }
                R.id.radioBtn_blue ->
                    if (checked){
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    }
            }
        }
    }




}