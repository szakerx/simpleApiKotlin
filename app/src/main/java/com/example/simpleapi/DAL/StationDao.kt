package com.example.simpleapi.DAL

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.simpleapi.models.Station
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class StationDao {

    private val retrofit: Retrofit =
        Retrofit.Builder().baseUrl("http://api.gios.gov.pl/pjp-api/rest/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    private val service: Api = retrofit.create(Api::class.java)

    fun getStations(): LiveData<List<Station>> {
        val stations = MutableLiveData<List<Station>>()
        val call = service.getStations()
        call.enqueue(object : Callback<List<Station>> {
            override fun onResponse(call: Call<List<Station>>, response: Response<List<Station>>) {
                if (!response.isSuccessful)
                    stations.value = listOf(Station())
                else
                    stations.value = response.body()
            }

            override fun onFailure(call: Call<List<Station>>, t: Throwable) {
                stations.value = listOf(Station())
            }
        })
        return stations
    }
}