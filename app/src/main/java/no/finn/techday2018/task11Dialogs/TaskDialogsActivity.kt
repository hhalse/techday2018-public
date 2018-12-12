package no.finn.techday2018.task11Dialogs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import no.finn.techday2018.R
import androidx.appcompat.app.AlertDialog
import com.google.android.material.bottomsheet.BottomSheetDialog


class TaskDialogsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)
    }

    fun showDialogClicked(v: View) {
        AlertDialog.Builder(this)
            .setTitle("Closing this window")
            .setMessage("Are you sure you want to do it?")
            .setPositiveButton("Yes", { dialog, which -> finish() })
            .setNegativeButton("No", null).show()

    }

    fun showBottomSheetDialogClicked(v: View) {
        val bottomSheetDialog = BottomSheetDialog(this)
        val inflater = LayoutInflater.from(this)
        val bottomSheetLayout = inflater.inflate(R.layout.activity_dialog_bottom_sheet, null)

        bottomSheetDialog.setContentView(bottomSheetLayout)
        bottomSheetDialog.show()
    }

}
