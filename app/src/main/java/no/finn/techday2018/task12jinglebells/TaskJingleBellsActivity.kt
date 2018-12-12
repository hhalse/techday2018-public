package no.finn.techday2018.task12jinglebells

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import no.finn.techday2018.R

class TaskJingleBellsActivity : AppCompatActivity(), AccelSensor.OnAccelEvent {

    private val accelSensor = AccelSensor(this)
    private val mediaPlayer = MediaPlayer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jingle_bells)
        initMediaPlayer()
    }

    private fun initMediaPlayer() {
        val descriptor = this.assets.openFd("jingle_bells.wav")
        mediaPlayer.setDataSource(
            descriptor.fileDescriptor,
            descriptor.startOffset,
            descriptor.length
        )
        descriptor.close()

        mediaPlayer.prepare()
        mediaPlayer.setVolume(0.5f, 0.5f)
        mediaPlayer.isLooping = false
    }

    private fun playSound() {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.pause()
            mediaPlayer.seekTo(0)
        }
        mediaPlayer.start()
    }

    override fun onResume() {
        super.onResume()
        accelSensor.onResume(this)
    }

    override fun onPause() {
        super.onPause()
        accelSensor.onPause()   // save battery
    }

    override fun onShake() {
        playSound()
    }

}
