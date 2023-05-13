package com.example.examplenewsapi.network

import com.example.examplenewsapi.model.Article
import com.example.examplenewsapi.model.ResponseDataSource
import com.example.examplenewsapi.model.Source
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines/sources")
    fun getAllSources(
        @Query("category") category: String,
        @Query("apikey") apiKey : String = "f827493d7bcf4de0b82e63f33b1e698e"
    ) : Call<List<Source>>

    @GET("top-headlines")
    fun gellAllArticles(
        @Query("sources") sources : String,
        @Query("apiKey") apiKey : String = "ad992dbb7a9c4b15bb9b37e5d4ef3358"
    ) : Call<List<Article>>
}