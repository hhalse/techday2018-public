package no.finn.techday2018.task9masterdetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import no.finn.techday2018.R

import no.finn.techday2018.task9masterdetail.dummy.DummyContent
import kotlinx.android.synthetic.main.activity_techitem_list.*
import kotlinx.android.synthetic.main.techitem_list_content.view.*
import kotlinx.android.synthetic.main.techitem_list.*

class TechItemListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_techitem_list)
        setSupportActionBar(toolbar)
        toolbar.title = title
        setupRecyclerView(techitem_list)
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        recyclerView.adapter = SimpleItemRecyclerViewAdapter(DummyContent.ITEMS)
    }

    class SimpleItemRecyclerViewAdapter(
        private val values: List<DummyContent.DummyItem>
    ) :
        RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder>() {

        init {
            // Here we are initing all items(ViewHolders) in the adapter
            // 1. If we click on an item we would like to go to the next page

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            //Here the item is inflated
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.techitem_list_content, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            // And here the view is "binded"
            // We would like to listen to some click and launching a new activity
            val item = values[position]
            holder.idView.text = item.id
            holder.contentView.text = item.content

            with(holder.itemView) {
                tag = item
            }
        }

        override fun getItemCount() = values.size

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val idView: TextView = view.id_text
            val contentView: TextView = view.content
        }
    }
}
