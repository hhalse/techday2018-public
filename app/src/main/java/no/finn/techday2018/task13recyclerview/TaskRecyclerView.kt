package no.finn.techday2018.task13recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_task_recycler_view.*
import no.finn.techday2018.R

class TaskRecyclerView : AppCompatActivity() {

    private val gson: Gson by lazy {
        GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES)
            .create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(this)

        // 1: Create an adapter and set it to the recycler view.
        // The adapter provides the items to the recycler view.
        // https://developer.android.com/guide/topics/ui/layout/recyclerview


        // 2: Add items to the adapter.
    }

    private fun loadAdItems(): List<AdItem> {
        val inputStream = resources.openRawResource(R.raw.result)
        val json = inputStream.bufferedReader().use { it.readText() }
        return gson.fromJson(json, object : TypeToken<List<AdItem>>() {}.type)
    }
}
