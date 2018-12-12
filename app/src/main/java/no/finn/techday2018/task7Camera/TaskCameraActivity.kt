package no.finn.techday2018.task7Camera

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import no.finn.techday2018.R

class TaskCameraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_task_camera_intent)
//        https://developer.android.com/guide/topics/media/camera
//        https://developer.android.com/training/camera/photobasics
        init()
    }

    fun init() {
        //1. Take a picture with the camera and show either a thumbnail or a fullsize image in our app

    }
}
