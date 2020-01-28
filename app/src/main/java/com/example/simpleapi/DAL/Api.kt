package com.example.simpleapi.DAL

import com.example.simpleapi.models.Station
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("station/findAll")
    fun getStations(): Call<List<Station>>
}