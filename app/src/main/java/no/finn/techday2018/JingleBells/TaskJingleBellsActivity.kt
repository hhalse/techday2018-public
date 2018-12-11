package no.finn.techday2018.JingleBells

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import no.finn.techday2018.R
import android.media.MediaPlayer

class TaskJingleBellsActivity : AppCompatActivity(), AccelSensor.OnAccelEvent {

    private val accelSensor = AccelSensor(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jingle_bells)
    }

    fun playSound() {
        playAssetSound(this, "jingle_bells.wav")
    }

    override fun onResume() {
        super.onResume()
        accelSensor.onResume(this)
    }

    override fun onPause() {
        super.onPause()
        accelSensor.onPause()
    }

    override fun onShake() {
        playSound()
    }

    fun playAssetSound(context: Context, soundFileName: String) {
        try {
            val mediaPlayer = MediaPlayer()

            val descriptor = context.getAssets().openFd(soundFileName)
            mediaPlayer.setDataSource(
                descriptor.getFileDescriptor(),
                descriptor.getStartOffset(),
                descriptor.getLength()
            )
            descriptor.close()

            mediaPlayer.prepare()
            mediaPlayer.setVolume(0.5f, 0.5f)
            mediaPlayer.isLooping = false
            mediaPlayer.start()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

}
