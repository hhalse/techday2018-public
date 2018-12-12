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
    private val inflater: LayoutInflater by lazy { LayoutInflater.from(context) }

    var items: List<AdItem> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdItemViewHolder {
        val layout = inflater.inflate(R.layout.ad_item, parent, false)
        return AdItemViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: AdItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

}

class AdItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val imageView: ImageView = itemView.imageView
    val imageOverlay: TextView = itemView.imageOverlay
    val titleView: TextView = itemView.titleView

    fun bind(adItem: AdItem) {
        Glide
            .with(imageView)
            .load(adItem.imageUrl)
            .into(imageView)
        titleView.text = adItem.title
        imageOverlay.text = adItem.imageOverlay
    }
}