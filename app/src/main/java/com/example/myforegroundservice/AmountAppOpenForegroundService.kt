package com.example.myforegroundservice

import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat

const val RC_OPEN_ACTIVITY = 0

class AmountAppOpenForegroundService : Service() {

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        val amountAppOpenings = intent.getIntExtra(KEY_AMOUNT_APP_OPENINGS, 0)

        val notificationIntent = Intent(this, MainActivity::class.java)
        val notificationPendingIntent = PendingIntent.getActivity(
            this,
            RC_OPEN_ACTIVITY,
            notificationIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        val notification = NotificationCompat.Builder(
            this,
            getString(R.string.amount_app_open_channel_id)
        ).apply {
            setContentTitle(getString(R.string.amount_app_open_content_title))
            setContentText(getString(R.string.amount_app_open_content_text, amountAppOpenings))
            setSmallIcon(R.drawable.ic_statistics)
            setContentIntent(notificationPendingIntent)
            priority = NotificationCompat.PRIORITY_HIGH
        }

        startForeground(R.integer.amount_app_open_notification_id, notification.build())

        return START_NOT_STICKY
    }

}