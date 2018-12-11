package no.finn.techday2018.taskExternalImage

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.task_external_image_item.view.*
import no.finn.techday2018.R
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.widget.ImageView
import java.net.URL


/**
 * This is an implementation of an Adapter suitable for a RecyclerView.
 * Its constructor takes a list of URL's in String format and a Context used for View creation.
 *
 * The onBindViewHolder method presents us to the framework Glide.
 * """Glide is a fast and efficient image loading library for Android focused on smooth scrolling""" - bumptech.github.io/glide/
 *
 * Let's use Glide to load the images for us and present them in the RecyclerView.
 * It seems like the code is commented out because some parts are missing.
 *
 */
class ExternalImageRecyclerViewAdapter(val urls: List<String>, val context: Context): RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.task_external_image_item, parent, false))
    }

    /**
     * This returns the number of items in our list
     */
    override fun getItemCount(): Int {
        return urls.size
    }

    /**
     * This method asks us to bind a ViewHolder `holder` to an item with position `position`
     * This will be called every time a cell with this position is loaded in screen.
     * The ViewHolder contains an ImageView. That means that this is a perfect place for us to load the image.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        Glide
//            .with(holder.imageView)
//            .load( /* Here goes the url that Glide should load */)
//            .into( /* Here goes the ImageView Glide should load the image in */)
    }
}

class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val imageView = view.imageView
}




/**
 *
 * BONUS TASK:
 * Here is an unused private class with a naive implementation of downloading image to ImageView
 *
 * If you want to try it out, replace the code that loads the image with Glide with the following single row, to
 * see how it would look if we did not have the smooooth scrolling features of Glide.
 *
        DownloadImageTask(holder.imageView).execute(urls[position]) // <----- This row
 */
private class DownloadImageTask(internal var bmImage: ImageView?) : AsyncTask<String, Void, Bitmap>() {

    override fun doInBackground(vararg urls: String): Bitmap? {
        val url = urls[0]
        var bitmap: Bitmap? = null
        try {
            val stream = URL(url).openStream()
            bitmap = BitmapFactory.decodeStream(stream)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return bitmap
    }

    override fun onPostExecute(result: Bitmap?) {
        if (result != null) {
            bmImage?.setImageBitmap(result)
        }

    }
}