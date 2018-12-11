package no.finn.techday2018

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import no.finn.techday2018.JingleBells.JingleBellsActivity
import no.finn.techday2018.WebView.WebViewActivity
import no.finn.techday2018.masterDetail.TechItemListActivity
import no.finn.techday2018.task1.Task1
import no.finn.techday2018.task2databinding.TaskViewBindingActivity
import no.finn.techday2018.taskCamera.TaskCameraActivity
import no.finn.techday2018.taskImage.TaskImageActivity
import no.finn.techday2018.taskNotifications.TaskNotificationsActivity
import no.finn.techday2018.taskOrientation.TaskOrientationActivity
import no.finn.techday2018.taskjson.TaskLoadJsonActivity
import no.finn.techday2018.taskuievents.TaskUiEventsActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val taskListAdapter = TaskListAdapter()
        taskListAdapter.items = listOf(
            TaskListItem(Task1::class.java, "Hello, world!", R.drawable.hello_world),
            TaskListItem(TaskViewBindingActivity::class.java, "View binding", R.drawable.eddy),
            TaskListItem(TaskUiEventsActivity::class.java, "Ui Events", R.drawable.touch, "touch"),
            TaskListItem(TaskOrientationActivity::class.java, "Layout orientation", R.drawable.reindeer, "reindeer"),
            TaskListItem(TaskImageActivity::class.java, "Load Images", R.drawable.painting_landscape),
            TaskListItem(TaskNotificationsActivity::class.java, "Notifications", R.drawable.hwoarang),
            TaskListItem(TaskCameraActivity::class.java, "Take a photo", R.drawable.mokujin),
            //TaskListItem(WebViewActivity::class.java, getString(R.string.web_view), R.drawable.hello_world),
            TaskListItem(TechItemListActivity::class.java, "Master detail", R.drawable.ling_xiayu),
            TaskListItem(TaskLoadJsonActivity::class.java, "Load resources (local and network)", R.drawable.jack),
            TaskListItem(JingleBellsActivity::class.java, getString(R.string.jingle_bells), R.drawable.accelerometer_icon)
        )
        taskList.adapter = taskListAdapter
        taskList.layoutManager = LinearLayoutManager(this)
    }
}
