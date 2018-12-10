package no.finn.techday2018.taskjson

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface BackendService {
    @GET("baldermork/79fb6ea5ef8ae46d1c2f3c7a8ec89f82/raw/9b74ef9055f5790487f9ee6aa9620171d6ee8f41/hello.txt")
    fun getHelloWorldString(): Call<ResponseBody>

    @GET("baldermork/5ed669951479c7e66418f892658d9c3c/raw/1440040fc25ef689e5725a2fc037050441f8e3d9/result.json")
    fun getSearchResult(): Call<List<AdItem>>
}