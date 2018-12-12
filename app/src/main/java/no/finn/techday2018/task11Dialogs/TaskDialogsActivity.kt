package no.finn.techday2018.task11Dialogs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import no.finn.techday2018.R

class TaskDialogsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_dialogs)
    }

    fun showDialogClicked(v: View) {
        // show a dialog with YES and NO buttons
        // https://developer.android.com/guide/topics/ui/dialogs
    }

    fun showBottomSheetDialogClicked(v: View) {
        // create a bottom sheet dialog (BottomSheetDialog)
        // set it's content to the layout: activity_task_dialogs_bottom_sheet
        // show it
    }

}
