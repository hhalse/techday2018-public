package no.finn.techday2018.task9masterdetail

import android.content.Intent
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
import no.finn.techday2018.task9masterdetail.TechItemDetailActivity.Companion.ARG_ITEM_ID

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

        private val onClickListener: View.OnClickListener

        init {
            onClickListener = View.OnClickListener { v ->
                val item = v.tag as DummyContent.DummyItem
                    val intent = Intent(v.context, TechItemDetailActivity::class.java).apply {
                        putExtra(ARG_ITEM_ID, item.id)
                    }
                    v.context.startActivity(intent)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.techitem_list_content, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = values[position]
            holder.idView.text = item.id
            holder.contentView.text = item.content

            with(holder.itemView) {
                tag = item
                setOnClickListener(onClickListener)
            }
        }

        override fun getItemCount() = values.size

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val idView: TextView = view.id_text
            val contentView: TextView = view.content
        }
    }
}
