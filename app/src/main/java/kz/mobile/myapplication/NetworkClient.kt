package kz.mobile.myapplication

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Singleton pattern in Kotlin
object ApiClient {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    //Lazy initialization
    val apiClient: PlaceHolderApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return@lazy retrofit.create(PlaceHolderApi::class.java)
    }
}