package com.example.geeks_for_eeks_news_app

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

const val API = "f4599b7140714024b8f3e134f6cd8303"
const val CATEGORY= "business"
const val headlines_endpoint="v2/top-headlines?apiKey=$API"

interface News_Services {

    @GET(headlines_endpoint)
    fun get_headline(
        @Query("country")country :String,
        @Query("page") page :Int,
        @Query("category") category :String)
    : Call<News>
}