package com.mzweather.android.ui.place


import android.service.autofill.Transformation
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.mzweather.android.logic.Repository
import com.mzweather.android.logic.model.Place
import retrofit2.http.Query

class PlaceViewModel :ViewModel(){
    private val searchLiveData = MutableLiveData<String>()
    val placeList = ArrayList<Place>()
    val placeLiveData:LiveData<Result<List<Place>>> = searchLiveData.switchMap {query ->
        Repository.searchPlaces(query)
    }
    fun searchPlaces(query: String){
        searchLiveData.value = query
    }
}