package com.example.myforegroundservice

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        createAmountAppOpenNotificationChannel()
    }

    private fun createAmountAppOpenNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel(
                getString(R.string.amount_app_open_channel_id),
                getString(R.string.app_name),
                NotificationManager.IMPORTANCE_HIGH
            ).also { channel ->
                getSystemService(NotificationManager::class.java).apply {
                    createNotificationChannel(channel)
                }
            }
        }
    }
}