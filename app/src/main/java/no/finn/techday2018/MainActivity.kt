package no.finn.techday2018

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import no.finn.techday2018.task1.Task1
import no.finn.techday2018.task2databinding.Task2DataBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val taskListAdapter = TaskListAdapter()
        taskListAdapter.items = listOf(
            TaskListItem(Task1::class.java, "Hello, world!", R.drawable.hello_world),
            TaskListItem(Task2DataBinding::class.java, "Data binding", R.drawable.hello_world)
        )
        taskList.adapter = taskListAdapter
        taskList.layoutManager = LinearLayoutManager(this)
    }
}
