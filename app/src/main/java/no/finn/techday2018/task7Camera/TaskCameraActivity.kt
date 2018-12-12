package no.finn.techday2018.task7Camera

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.layout_task_camera_intent.*
import no.finn.techday2018.R

class TaskCameraActivity : AppCompatActivity() {

    val REQUEST_IMAGE_CAPTURE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        //Take a picture with the camera and show either a thumbnail or a fullsize image in our app
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_task_camera_intent)
//        https://developer.android.com/guide/topics/media/camera
//        https://developer.android.com/training/camera/photobasics
        init()
    }

    fun init() {
        button.setOnClickListener { button ->
            dispatchTakePictureIntent()
        }
    }

    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            thumbnail.setImageBitmap(imageBitmap)
        }
    }
}
