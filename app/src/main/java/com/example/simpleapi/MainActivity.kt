package com.example.simpleapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.simpleapi.DAL.StationDao
import com.example.simpleapi.models.Station
import com.example.simpleapi.viewmodels.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val factory = InjectorUtils.provideUserViewModelFactory()
        viewModel = ViewModelProviders.of(this, factory).get(MainActivityViewModel::class.java)
        initUi()
    }

    private fun initUi() {

        val spinner1 = findViewById<Spinner>(R.id.spinner1)

        viewModel.getStations().observe(this, Observer { data ->
            if (data != null) {
                val adapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, data)
                adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner1.adapter = adapter1
            }
        })
    }
}