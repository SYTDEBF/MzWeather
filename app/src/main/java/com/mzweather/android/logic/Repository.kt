package com.mzweather.android.logic


import androidx.lifecycle.liveData
import com.mzweather.android.logic.model.Place
import com.mzweather.android.logic.network.MzWeatherNetWork
import kotlinx.coroutines.Dispatchers

import retrofit2.http.Query

object Repository {
    fun searchPlaces(query: String) = liveData(Dispatchers.IO) {
        val result = try {
            val placeResponse = MzWeatherNetWork.searchPlace(query)
            if (placeResponse.status == "ok"){
                val place = placeResponse.places
                Result.success(place)
            }else{
                Result.failure(RuntimeException("response status is ${placeResponse.status}"))
            }
        } catch (e:Exception){
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }
}