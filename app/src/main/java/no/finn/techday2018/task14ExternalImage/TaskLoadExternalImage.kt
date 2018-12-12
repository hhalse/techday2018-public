package no.finn.techday2018.task14ExternalImage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_task_external_images.*
import no.finn.techday2018.R
import java.io.BufferedReader
import java.io.InputStreamReader


/**
 * This Activity consists of a RecyclerView with cells in two columns.
 * Each cell is supposed to show an image of a kitten.
 *
 * ExternalImageRecyclerViewAdapter is our implementation of Adapter that gives our RecyclerView cells to show.
 * Take a look in there to see what might be missing.
 */
class TaskLoadExternalImage: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_external_images)

        // We create an adapter that will provide our RecyclerView with cells
        recycler_view.adapter = ExternalImageRecyclerViewAdapter(loadKittenUrls(), this)

        // We set a GridLayoutManager to make the RecyclerView show 2 columns
        recycler_view.layoutManager = GridLayoutManager(this, 2)


    }


    /**
     * Load in the URLs of the kittens
     * The kitten URLs are loaded from a file in assets called kittens.txt
     * It's located in App -> assets
     */
    private fun loadKittenUrls(): List<String> {
        val list = arrayListOf<String>()
        val inputStream = assets.open("kittens.txt")
        val reader = BufferedReader(InputStreamReader(inputStream))
        var line = reader.readLine()
        while (line != null) {
            line = reader.readLine()
            list.add(line)
        }
        return list
    }
}
