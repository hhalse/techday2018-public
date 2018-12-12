package no.finn.techday2018.task2databinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_task2_databinding.*
import no.finn.techday2018.R
import android.graphics.drawable.ColorDrawable


class TaskViewBindingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task2_databinding)

        init()
    }

    private fun init() {
        //1. When the input in the edit text is updated update the textview
        //2. See if you can change the color of the background when clicking the button
        //3. And if possible use a value animater when changing color so it looks smooth

        button.setOnClickListener { button ->

        }
    }

    private fun getNewColors(): Pair<Int, Int> {
        val viewColor = containerView.background as ColorDrawable
        val currentColor = viewColor.color
        return if (currentColor == resources.getColor(R.color.colorPrimaryDark, theme)) {
            Pair(resources.getColor(R.color.colorPrimaryDark, theme), resources.getColor(R.color.colorAccent, theme))
        } else {
            Pair(resources.getColor(R.color.colorAccent, theme), resources.getColor(R.color.colorPrimaryDark, theme))
        }
    }

}