package no.finn.techday2018.taskNotifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_task_notifications.*
import no.finn.techday2018.R
import kotlin.math.roundToInt

class TaskNotifications: AppCompatActivity() {

    private val notificationChannelId: String = "CHANNEL_ID_X"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_notifications)
        createNotificationChannel()
        initListeners()
    }

    private fun initListeners() {
        button.setOnClickListener { button ->
            createNotification()
        }
    }

    private fun createNotification() {
        // https://developer.android.com/training/notify-user/build-notification

        //Change icon to a snowy one
        var mBuilder = NotificationCompat.Builder(this, notificationChannelId)
            .setSmallIcon(R.drawable.notification_icon_background)
            .setContentTitle("Tech Day")
            .setContentText("Change the icon to a snowy one and add jingle bell lyrics")
            .setStyle(NotificationCompat.BigTextStyle()
                .bigText("Jingle bells, jingle bells\n" +
                        "Jingle all the way,\n" +
                        "Oh what fun it is to ride\n" +
                        "In a one-horse open sleigh, \n" +
                        "Jingle bells, jingle bells\n" +
                        "Jingle all the way,\n" +
                        "Oh what fun it is to ride\n" +
                        "In a one-horse open sleigh.\n" +
                        "Dashing through the snow\n" +
                        "In a one-horse open sleigh\n" +
                        "Through the fields we go\n" +
                        "Laughing all the way.\n" +
                        "Bells on bob-tail ring\n" +
                        "Making spirits bright\n" +
                        "What fun it is to ride and sing\n" +
                        "A sleighing song tonight.")
            )
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        //Try changing style to BigText

        with(NotificationManagerCompat.from(this)) {
            // notificationId is a unique int for each notification that you must define
            notify((Math.random() * 1000).roundToInt(), mBuilder.build())
        }
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