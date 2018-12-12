package no.finn.techday2018.task3uievents

import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_ui_events.*
import no.finn.techday2018.R

class TaskUiEventsActivity : AppCompatActivity() {
    internal var mPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ui_events)

        // to interact with any view components in Android the view must be casted to different types like button, text and layouts
        val resetButtonBindById = findViewById<Button>(R.id.resetButton)
        //or you could just access it by id direcetly:
        //resetButtton

        //text view binding
        val headerText = findViewById<TextView>(R.id.headerText)
        val bodyText = findViewById<TextView>(R.id.bodyText)

        //we can now use button objects to add event listener also we can use this do some manipulation of button likes enable/disable etc..
        changeColorButton.setOnClickListener {
            //here you can write what you want to do with the click
            headerText.setTextColor(Color.GREEN)
            bodyText.setTextColor(Color.BLUE)
        }

        resetButtonBindById.setOnClickListener {
            //recreating the activity to reset everything

            mPlayer?.stop()
            finish()
            startActivity(intent)
        }

        //long press click listener
        longPressButton.setOnLongClickListener {
            longPressButton.setBackgroundColor(Color.RED)
            false
        }

        playJingleButton.setOnClickListener {
            mPlayer = MediaPlayer.create(this@TaskUiEventsActivity, R.raw.jingle1)
            mPlayer?.start()
        }
    }


}
