package no.finn.techday2018.task13recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.ad_item.view.*
import no.finn.techday2018.R

class AdItemListAdapter(context: Context) : RecyclerView.Adapter<AdItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdItemViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        // https://developer.android.com/guide/topics/ui/layout/recyclerview
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        // https://developer.android.com/guide/topics/ui/layout/recyclerview
    }

    override fun onBindViewHolder(holder: AdItemViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        // https://developer.android.com/guide/topics/ui/layout/recyclerview
    }

    private val inflater: LayoutInflater by lazy { LayoutInflater.from(context) }

    var items: List<AdItem> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
}

class AdItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val imageView: ImageView = itemView.imageView
    val imageOverlay: TextView = itemView.imageOverlay
    val titleView: TextView = itemView.titleView

    fun bind(adItem: AdItem) {
        // https://developer.android.com/guide/topics/ui/layout/recyclerview
    }
}