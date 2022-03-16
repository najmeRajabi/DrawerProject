package com.example.drawerproject

import androidx.lifecycle.ViewModel

class InfoViewModel:ViewModel() {
    private val info = Information()
    val arrayInfo = info.dataArray
}