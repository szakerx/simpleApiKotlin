package com.example.simpleapi.DAL

class Database private constructor() {

    var stationDao = StationDao()
        private set

    companion object{
        private var instance: Database? = null

        fun getInstance(): Database {
            if(instance==null)
                instance = Database()
            return instance as Database
        }
    }
}