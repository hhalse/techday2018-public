package no.finn.techday2018

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.RecyclerView


class TaskListAdapter : RecyclerView.Adapter<TaskListItemHolder>() {
    var items: List<TaskListItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskListItemHolder {
        val inflater = LayoutInflater.from(parent.context)
        val layout = inflater.inflate(R.layout.task_list_item, parent, false)
        return TaskListItemHolder(layout)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: TaskListItemHolder, position: Int) = holder.bind(items[position])
}

data class TaskListItem(
    val activityClass: Class<*>,
    val label: String, @DrawableRes val imageResource: Int,
    val imageTransitionName: String? = null
)

class TaskListItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val imageView: ImageView = itemView.findViewById(R.id.imageView)
    private val textView: TextView = itemView.findViewById(R.id.textView)

    fun bind(item: TaskListItem) {
        imageView.transitionName = item.imageTransitionName
        imageView.setImageResource(item.imageResource)
        textView.text = item.label
        itemView.setOnClickListener {
            val launchIntent = Intent(itemView.context, item.activityClass)
            val options = createAvatarTransitionOptions(itemView.context as Activity, imageView)
            itemView.context.startActivity(launchIntent, options.toBundle())
        }
    }

    private fun createAvatarTransitionOptions(activity: Activity, imageView: ImageView): ActivityOptionsCompat {
        return ActivityOptionsCompat.makeSceneTransitionAnimation(activity, imageView, imageView.transitionName)
    }
}