package kz.mobile.myapplication

import com.google.gson.annotations.SerializedName


data class Post(
    @SerializedName("userId") val userId: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("body") val body: String,
    @SerializedName("title") val title: String
)