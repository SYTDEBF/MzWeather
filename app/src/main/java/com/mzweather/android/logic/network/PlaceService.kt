package com.mzweather.android.logic.network

import com.mzweather.android.MzWeatherApplication
import com.mzweather.android.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceService {
    @GET("https://api.caiyunapp.com/v2/place?token=${MzWeatherApplication.TOKEN}&lang=zh_CN")
    fun searchPlace(@Query("query") query: String):Call<PlaceResponse>
}