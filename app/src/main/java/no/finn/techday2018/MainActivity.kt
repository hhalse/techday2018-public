package no.finn.techday2018

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import no.finn.techday2018.taskDialogs.TaskDialogsActivity
import no.finn.techday2018.JingleBells.TaskJingleBellsActivity
import no.finn.techday2018.task8webview.TaskWebViewActivity
import no.finn.techday2018.masterDetail.TechItemListActivity
import no.finn.techday2018.task1.Task1
import no.finn.techday2018.task2databinding.TaskViewBindingActivity
import no.finn.techday2018.task7Camera.TaskCameraActivity
import no.finn.techday2018.taskExternalImage.TaskLoadExternalImage
import no.finn.techday2018.task6Notifications.TaskNotificationsActivity
import no.finn.techday2018.task4Orientation.TaskOrientationActivity
import no.finn.techday2018.taskjson.TaskLoadJsonActivity
import no.finn.techday2018.taskrecyclerview.TaskRecyclerView
import no.finn.techday2018.tasksnow.TaskSnowActivity
import no.finn.techday2018.task3uievents.TaskUiEventsActivity
import no.finn.techday2018.task5Image.TaskImageActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val taskListAdapter = TaskListAdapter()
        taskListAdapter.items = listOf(
            TaskListItem(Task1::class.java, getString(R.string.task_label_hello_world), R.drawable.hello_world),
            TaskListItem(TaskViewBindingActivity::class.java, getString(R.string.task_label_view_binding), R.drawable.eddy),
            TaskListItem(TaskUiEventsActivity::class.java, getString(R.string.task_label_ui_events), R.drawable.touch, getString(R.string.transition_touch)),
            TaskListItem(TaskOrientationActivity::class.java, getString(R.string.task_label_orientation), R.drawable.santa, getString(R.string.transition_santa)),
            TaskListItem(TaskImageActivity::class.java, getString(R.string.task_label_image), R.drawable.painting_landscape),
            TaskListItem(TaskNotificationsActivity::class.java, getString(R.string.task_label_notifications), R.drawable.hwoarang),
            TaskListItem(TaskCameraActivity::class.java, getString(R.string.task_label_camera), R.drawable.mokujin),
            TaskListItem(TaskWebViewActivity::class.java, getString(R.string.task_label_web_view), R.drawable.random_tekken),
            TaskListItem(TechItemListActivity::class.java, getString(R.string.task_label_master_detail), R.drawable.ling_xiayu),
            TaskListItem(TaskLoadJsonActivity::class.java, getString(R.string.task_label_load_json), R.drawable.jack),
            TaskListItem(TaskDialogsActivity::class.java, getString(R.string.task_label_dialogs), R.drawable.hello_world),
            TaskListItem(TaskJingleBellsActivity::class.java, getString(R.string.task_label_jingle_bells), R.drawable.accelerometer_icon),
            TaskListItem(TaskRecyclerView::class.java, getString(R.string.task_label_recyclerview), R.drawable.asuka),
            TaskListItem(TaskSnowActivity::class.java, getString(R.string.task_label_snow), R.drawable.snowflake),
            TaskListItem(TaskLoadExternalImage::class.java, getString(R.string.task_label_external_images), R.drawable.glide_logo)

        )
        taskList.adapter = taskListAdapter
        taskList.layoutManager = LinearLayoutManager(this)
    }
}
