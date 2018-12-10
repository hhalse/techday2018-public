package no.finn.techday2018.task2databinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_task2_databinding.*
import no.finn.techday2018.R

class Task2DataBinding : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task2_databinding)

        init()
    }

    private fun init() {
        editText.onChange { newText -> textView.text = newText}
    }
}