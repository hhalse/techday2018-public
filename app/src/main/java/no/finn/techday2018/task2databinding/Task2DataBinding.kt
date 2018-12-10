package no.finn.techday2018.task2databinding

import android.animation.ValueAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_task2_databinding.*
import no.finn.techday2018.R
import android.graphics.drawable.ColorDrawable


class Task2DataBinding : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task2_databinding)

        init()
    }

    private fun init() {
        editText.onChange { newText -> textView.text = newText}

        //See if you can change the color of the background when clicking the button
        //And if possible use animation when changing color


        button.setOnClickListener { button ->
            val newColorPair = getNewColors()
            val animation = ValueAnimator.ofArgb(
                newColorPair.first,
                newColorPair.second
            )
            animation.addUpdateListener { valueAnimator ->
                containerView.setBackgroundColor(
                    valueAnimator.animatedValue as Int
                )
            }

            animation.duration = 1000
            animation.start()
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