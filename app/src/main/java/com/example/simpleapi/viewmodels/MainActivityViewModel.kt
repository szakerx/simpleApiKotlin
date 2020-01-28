package com.example.simpleapi.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simpleapi.DAL.Repository
import com.example.simpleapi.models.MeasureStation
import com.example.simpleapi.models.Station

class MainActivityViewModel(private val repository: Repository) : ViewModel() {

//    private val measures = MutableLiveData<List<MeasureStation>>()

    fun getStations(): LiveData<List<Station>> {
        return repository.getStations()
    }

//    fun getStations2(): LiveData<List<Station>> {
//        if(repository.getStations() != null) {
//            liveStations.value = repository.getStations()
//            return liveStations
//        }
//        liveStations.value = listOf(Station(2115,"ViewModel got null"))
//        return liveStations
//    }

//    fun getMeasures(): LiveData<List<MeasureStation>> {
//        return measures
//    }
}