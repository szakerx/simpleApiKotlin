package com.example.simpleapi

import com.example.simpleapi.DAL.Database
import com.example.simpleapi.DAL.Repository
import com.example.simpleapi.viewmodels.MainActivityViewModelFactory

object InjectorUtils {

    fun provideUserViewModelFactory(): MainActivityViewModelFactory {
        val repository = Repository.getInstance(Database.getInstance().stationDao)
        return MainActivityViewModelFactory(
            repository
        )
    }
}