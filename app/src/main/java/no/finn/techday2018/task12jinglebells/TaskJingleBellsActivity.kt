package no.finn.techday2018.task12jinglebells

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import no.finn.techday2018.R

class TaskJingleBellsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jingle_bells)

        // implement a SensorEventListener to detect shake event
        // when shaken, play the sound file in the assets folder: "jingle_bells.wav"

        // https://stackoverflow.com/questions/5271448/how-to-detect-shake-event-with-android
        // https://stackoverflow.com/questions/3289038/play-audio-file-from-the-assets-directory

        // using the emulator: Open the ... menu to the right of the emulator,select Virtual sensors, in the Move page drag the sliders to make a shake gesture
    }

    override fun onResume() {
        super.onResume()
        // start listening to accelerometer events
    }

    override fun onPause() {
        super.onPause()
        // stop listening to accelerometer events to save battery
    }

}
