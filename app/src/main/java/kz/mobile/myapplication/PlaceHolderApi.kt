package kz.mobile.myapplication

import com.google.gson.JsonArray
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.GET

interface PlaceHolderApi {

    @GET("posts")
    fun getPosts(): Call<List<Post>>

    @GET("posts")
    fun getPostsAsArray(): Call<JsonArray>
}