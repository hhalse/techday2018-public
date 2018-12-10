package no.finn.techday2018.taskImage

import android.graphics.Color
import no.finn.techday2018.R
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class TaskImage: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_images)

        setupIntroductionText()
    }

    private fun setupIntroductionText() {
        val introText = "Android Images"

        val introTextField = findViewById<TextView>(R.id.introduction)
        introTextField.text = introText

        val start = "Let’s start with loading an image in our app."
        val path = "App -> res -> drawable"
        val doubleClick = "Double click"
        val filename = "activity_task_images.xml"
        val tryToChange = "Now try to change the image"

        val firstText = "$start An image that is included in" +
                " the project and bundled within the app will load quickly and reliable.\n" +
                "\n" +
                "Browse the project to the left in Android Studio. Under the top directory App, open " +
                "the following path $path. Here you can find all images in the app " +
                "project - ready to be used in the app. $doubleClick them if you want to take a look." +
                "\n\n" +
                "" +
                "Now take a look at the layout file for this Activity ($filename). " +
                "There is an element with the ImageView, which we use to show the Image. Take a " +
                "look at the comment above it." +
                "\n\n" +
                "$tryToChange to another image you found in the drawable" +
                " folder. It could be e.g ginger_bread or reindeer."

        val firstTextField = findViewById<TextView>(R.id.first)
        val spannable = SpannableString(firstText)
        highlight(spannable, firstText, start)
        highlight(spannable, firstText, path)
        highlight(spannable, firstText, doubleClick)
        highlight(spannable, firstText, filename)
        highlight(spannable, firstText, tryToChange)
        firstTextField.setText(spannable, TextView.BufferType.SPANNABLE)

    }

    private fun highlight(spannable: Spannable, text: String, highlight: String) {
        val indexOf = text.indexOf(highlight)
        spannable.setSpan(ForegroundColorSpan(Color.WHITE), indexOf, indexOf + highlight.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    }
}
