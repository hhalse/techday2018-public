package no.finn.techday2018.taskrecyclerview

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

        val adItemListAdapter = AdItemListAdapter(this)
        recyclerView.adapter = adItemListAdapter

        val adItems = loadAdItems()
        adItemListAdapter.items = adItems
    }

    private fun loadAdItems(): List<AdItem> {
        val inputStream = resources.openRawResource(R.raw.result)
        val json = inputStream.bufferedReader().use { it.readText() }
        return gson.fromJson(json, object : TypeToken<List<AdItem>>() {}.type)
    }
}
