package com.mzweather.android

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.view.View.OnCreateContextMenuListener

class MzWeatherApplication: Application() {
     @SuppressLint("StaticFieldLeak")
     companion object{
         lateinit var context: Context
         const val TOKEN = "4IpjpL1lAjz4891v"

     }
    override fun onCreate(){
        super.onCreate()
        context = applicationContext
    }
}