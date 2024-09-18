package com.example.hiltgradleimplementation.data

import android.content.SharedPreferences
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity.MODE_PRIVATE
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CounterViewModel @Inject constructor(
    private val sharedPreferences: SharedPreferences): ViewModel(){

    private val _counterVisits = MutableStateFlow(0)
    var counterVisits: StateFlow<Int> = _counterVisits.asStateFlow()
    private var count : Int = 0
    private val counter = "counterKey"

    fun newVisit(){
        getData()
        count++
        _counterVisits.value = count
        setData()
    }

    private fun setData(){
        with(sharedPreferences.edit()){
            putInt(counter, count)
            apply()
        }
    }

    private fun getData(){
        count = sharedPreferences.getInt(counter, 0)
    }

}