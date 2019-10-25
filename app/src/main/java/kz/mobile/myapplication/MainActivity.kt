package kz.mobile.myapplication

import android.net.DnsResolver
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.gson.JsonArray
import org.json.JSONArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        button.setOnClickListener {

        }

        Log.d("post_results", "start request")
        ApiClient.apiClient.getPosts().enqueue(object : Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.d("post_results", t.toString())
            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                Log.d("post_results", response.body()?.toString() ?: "null")
            }
        })

        ApiClient.apiClient.getPostsAsArray().enqueue(object : Callback<JsonArray> {
            override fun onFailure(call: Call<JsonArray>, t: Throwable) {

            }

            override fun onResponse(call: Call<JsonArray>, response: Response<JsonArray>) {
                val list = ArrayList<Post>()
                response.body()?.forEach { element ->
                    val post = Post(
                        userId = element.asJsonObject.get("userId").asInt,
                        id = element.asJsonObject.get("id").asInt,
                        title = element.asJsonObject.get("title").asString,
                        body = element.asJsonObject.get("body").asString
                    )
                    list.add(post)
                }
                Log.d("post_array_list", list.toString())
            }

        })
    }

}

