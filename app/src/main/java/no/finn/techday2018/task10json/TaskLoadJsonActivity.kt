package no.finn.techday2018.task10json

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_load_json.*
import no.finn.techday2018.R
import retrofit2.Retrofit

typealias DoOnSuccess<T> = (response: T) -> Unit
typealias DoOnFailure = (throwable: Throwable) -> Unit

class TaskLoadJsonActivity : AppCompatActivity() {

    private val gson: Gson by lazy { Gson() }
    private val retrofit: Retrofit by lazy {
        /**
         * Here, you'll need to find a way to tell Retrofit which server to connect to,
         * and for part 3, how to turn JSON into objects
         */
        Retrofit.Builder()
            .build()
    }
    private val backendService: BackendService by lazy { retrofit.create(BackendService::class.java) }

    /**
     * In this part of the workshop, you need to solve three tasks:
     *
     * 1) Download text content from an online file using Retrofit and display it
     *
     * 2) Read a JSON resource from the app bundle and parse it into a list of objects using Gson
     *
     * 3) Download a JSON resource from the Internet and parse it into a list of objects using Retrofit
     *
     * You'll need to edit the three load*() functions further down this file, the AdItem class (or the
     * Gson instantiation further up), and the BackendService interface.
     *
     * Useful links for this task:
     *
     * Gson user guide
     * https://github.com/google/gson/blob/master/UserGuide.md
     *
     * Retrofit
     * https://square.github.io/retrofit/
     *
     * Providing Android resources
     * https://developer.android.com/guide/topics/resources/providing-resources
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load_json)

        helloButton.setOnClickListener {
            loadHelloWorldFromNetwork(
                { helloString -> textView.text = helloString },
                { throwable -> textView.text = "Error: ${throwable.message}" }
            )
        }

        localJsonButton.setOnClickListener {
            loadAdListFromResources(
                { adItems -> textView.text = "Loaded ${adItems.size} ads from local file" },
                { throwable -> textView.text = "Error: ${throwable.message}" }
            )
        }

        networkJsonButton.setOnClickListener {
            loadAdListFromNetwork(
                { adItems -> textView.text = "Loaded ${adItems.size} ads from network" },
                { throwable -> textView.text = "Error: ${throwable.message}" }
            )
        }

    }

    private fun loadHelloWorldFromNetwork(doOnSuccess: DoOnSuccess<String>, doOnFailure: DoOnFailure) {
        /**
         * You'll need to add a method to BackendService, and call it from here. Download
         * this file using Retrofit, and invoke doOnSuccess with its string content:
         *
         * https://gist.githubusercontent.com/baldermork/79fb6ea5ef8ae46d1c2f3c7a8ec89f82/raw/9b74ef9055f5790487f9ee6aa9620171d6ee8f41/hello.txt
         */
        doOnFailure(NotImplementedError("Not implemented yet!"))
    }

    private fun loadAdListFromResources(doOnSuccess: DoOnSuccess<List<AdItem>>, doOnFailure: DoOnFailure) {
        /**
         * Here, you need to read the file result.json, bundled in the res/raw folder of the app. Use
         * Gson to parse it into a list of AdItem objects. When you're done, invoke doOnSuccess
         *
         */
        doOnFailure(NotImplementedError("Not implemented yet!"))
    }

    private fun loadAdListFromNetwork(doOnSuccess: DoOnSuccess<List<AdItem>>, doOnFailure: DoOnFailure) {
        /**
         * Use backendService to fetch the following file and turn it into a list of AdItems, then invoke
         * doOnSuccess with the resulting list:
         *
         * https://gist.githubusercontent.com/baldermork/5ed669951479c7e66418f892658d9c3c/raw/1440040fc25ef689e5725a2fc037050441f8e3d9/result.json
         */
        doOnFailure(NotImplementedError("Not implemented yet!"))
    }

}
