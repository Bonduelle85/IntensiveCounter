package com.example.intensivecounter

import android.app.Application
import com.example.intensivecounter.data.Repository
import com.example.intensivecounter.presentation.CounterViewModel

class CounterApp : Application() {

    lateinit var viewModel: CounterViewModel

    override fun onCreate() {
        super.onCreate()

        viewModel = CounterViewModel(Repository.Base())
    }
}