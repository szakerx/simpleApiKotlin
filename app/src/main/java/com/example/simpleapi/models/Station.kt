package com.example.simpleapi.models

import com.google.gson.annotations.SerializedName

class Station{

    @SerializedName("id")
    val id: Long = -1L
    @SerializedName("stationName")
    val name: String = "Default name"

    override fun toString(): String {
        return name
    }
}