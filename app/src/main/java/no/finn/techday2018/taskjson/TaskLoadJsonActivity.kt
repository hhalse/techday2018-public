package no.finn.techday2018.taskjson

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_load_json.*
import no.finn.techday2018.R
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

typealias DoOnSuccess<T> = (response: T) -> Unit
typealias DoOnFailure = (throwable: Throwable) -> Unit

class TaskLoadJsonActivity : AppCompatActivity() {

    private val gson: Gson by lazy { Gson() }
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://gist.githubusercontent.com")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
    private val backendService: BackendService by lazy { retrofit.create(BackendService::class.java) }

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
        backendService.getHelloWorldString().enqueue(object : Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                doOnFailure(t)
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                val helloWorld = response.body()?.string().orEmpty()
                doOnSuccess(helloWorld)
            }
        })
    }

    private fun loadAdListFromResources(doOnSuccess: DoOnSuccess<List<AdItem>>, doOnFailure: DoOnFailure) {
        try {
            val inputStream = resources.openRawResource(R.raw.result)
            val json = inputStream.bufferedReader().readText()
            val adItems = gson.fromJson<List<AdItem>>(json, object : TypeToken<List<AdItem>>() {}.type)
            doOnSuccess(adItems)
        } catch (t: Throwable) {
            doOnFailure(t)
        }
    }

    private fun loadAdListFromNetwork(doOnSuccess: DoOnSuccess<List<AdItem>>, doOnFailure: DoOnFailure) {
        backendService.getSearchResult().enqueue(object : Callback<List<AdItem>> {
            override fun onFailure(call: Call<List<AdItem>>, t: Throwable) {
                doOnFailure(t)
            }

            override fun onResponse(call: Call<List<AdItem>>, response: Response<List<AdItem>>) {
                val list = response.body() ?: emptyList()
                doOnSuccess(list)
            }
        })
    }

}