package no.finn.techday2018.task6Notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import no.finn.techday2018.R

class TaskNotificationsActivity: AppCompatActivity() {

    private val notificationChannelId: String = "CHANNEL_ID_X"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_notifications)
        createNotificationChannel()
        init()
    }

    private fun init() {
        // 1. Send a notification when the user clicks the button
        // 2. Change the notification icon to a more snowy one
        // 3. Try out some other notifications styles, such as BigTextStyle

        // Helpfull resource https://developer.android.com/training/notify-user/build-notification
    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = notificationChannelId
            val descriptionText = "Describe the channel"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(notificationChannelId, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}