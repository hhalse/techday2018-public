package no.finn.techday2018.task4Orientation

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.orientation_task_content.*
import no.finn.techday2018.R

class TaskOrientationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orientation)

        textViewDescription.text = buildDescriptionSpannable()
    }

    private fun buildDescriptionSpannable(): SpannableString {
        val highlights = arrayOf(
            "Activity",
            "activity_orientation.xml",
            "orientation_task_content.xml",
            " res ",
            "res/layout",
            "LinearLayout",
            "ImageView",
            "TextView"
        )

        var description = "In this task you will learn how to adjust your layout to fit different configurations."
        description += " The files we're going to look at are located inside the res/layout folder of your project."
        description += "\n\nThis Activity (screen) uses activity_orientation.xml as its main layout file. If you take a look inside this file, you will find that orientation_task_content.xml is included."
        description += " By extracting parts of the layout like this, we can provide a different look and feel for a wide range of configurations. In this task we're going to provide a different layout for the landscape orientation."
        description += "\n\nThe included orientation_task_content.xml consists of one ImageView and two TextViews, vertically stacked. In landscape mode, want the image to be placed on the left hand side of the texts. Follow these steps to complete the task:"
        description += "\n\n1) Create a new resource directory for landscape layouts. Hint: right click on the res folder, and select 'New'."
        description += "\n\n2) Copy orientation_task_content.xml into the landscape layout folder."
        description += "\n\n3) Modify the landscape layout so that the image is displayed on the left hand side of the texts. Hint: add another LinearLayout."
        description += "\n\n4) Optional - play around with different colors and/or text sizes for the landscape version."

        val spannable = SpannableString(description)
        highlights.forEach { word ->
            highlight(spannable, description, word)
        }
        return spannable
    }

    private fun highlight(spannable: Spannable, text: String, target: String) {
        val highlightColor = ForegroundColorSpan(resources.getColor(R.color.colorPrimary, theme))
        val startIndex = text.indexOf(target)
        val endIndex = startIndex + target.length
        spannable.setSpan(highlightColor, startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    }
}