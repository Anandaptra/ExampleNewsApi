package com.example.examplenewsapi.model


import com.google.gson.annotations.SerializedName

data class ResponseDataArticle(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)