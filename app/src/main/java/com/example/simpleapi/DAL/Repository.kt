package com.example.simpleapi.DAL

class Repository(private val stationDao: StationDao) {

    companion object{
        private var instance: Repository? = null

        fun getInstance(stationDao: StationDao): Repository {
            if(instance==null)
                instance = Repository(stationDao)
            return instance as Repository
        }
    }

    fun getStations() = stationDao.getStations()
}