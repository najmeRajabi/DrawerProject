package com.example.drawerproject

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.SeekBar
import androidx.navigation.fragment.findNavController
import com.example.drawerproject.databinding.FragmentSettingBinding

var NUMBER= 4
var SHOWINFO = false
const val THEME = "theme"
const val NAME = "name"
const val NATIONAL = "nationalCode"
const val PHONE = "phone"
const val IMAGE = "image"
const val ACCOUNTNUM = "AccountNum"
const val CARTNUM = "CartNum"
const val SHEBANUM = "ShebaNum"

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

        checkTheme()
        return binding.root
    }

    private fun checkTheme() {
        val sharedPreferences:SharedPreferences =
            requireActivity().getSharedPreferences("HW10_theme" , Context.MODE_PRIVATE)
        when (sharedPreferences.getString(THEME,"blue")){
            "blue" -> binding.radioBtnBlue.isChecked = true
            "pink" -> binding.radioBtnPink.isChecked = true
            "dark" -> binding.radioBtnDark.isChecked = true
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
            R.id.radioBtn_pink -> {
                saveThemeInSharedPref("pink")
                refresh()
            }
            R.id.radioBtn_blue -> {
                saveThemeInSharedPref("blue")
                refresh()
            }
            R.id.radioBtn_dark -> {

                saveThemeInSharedPref("dark")
                refresh()
            }
        }
        return null
    }

    private fun refresh() {
        activity?.finish()
        activity?.startActivity(Intent(context,MainActivity::class.java))
    }

    private fun checkRegistered() {
        val sharedPreferences:SharedPreferences =
            requireActivity().getSharedPreferences("HW10" , Context.MODE_PRIVATE)
        if (!sharedPreferences.getString(NAME,"").isNullOrBlank()){

        }
    }


    private fun saveThemeInSharedPref(theme:String) {
        val sharedPreferences:SharedPreferences =
            requireActivity().getSharedPreferences("HW10_theme" , Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit().apply {
            when (theme){
                "blue" -> this.putString(THEME,"blue")
                "pink" -> this.putString(THEME,"pink")
                "dark" -> this.putString(THEME,"dark")
                else -> this.putString(THEME,"blue")
            }
                .apply()
        }
    }




}