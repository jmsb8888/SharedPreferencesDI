package com.example.hiltgradleimplementation

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.hiltgradleimplementation.data.CounterViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: CounterViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.newVisit()
        lifecycleScope.launch {
            viewModel.counterVisits.collect {
                val visitsText = getString(R.string.cantidad_de_visitas, it)
                findViewById<TextView>(R.id.tvCounterVisits).text = visitsText

            }
        }
    }
}