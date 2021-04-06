package com.example.myforegroundservice

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.myforegroundservice.databinding.ActivityMainBinding

const val KEY_AMOUNT_APP_OPENINGS = "amount_app_openings"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(this, AmountAppOpenForegroundService::class.java)

        binding.btnStart.setOnClickListener {
            intent.putExtra(KEY_AMOUNT_APP_OPENINGS, ++i)
            ContextCompat.startForegroundService(this, intent)
        }

        binding.btnCancel.setOnClickListener {
            stopService(intent)
        }
    }


}