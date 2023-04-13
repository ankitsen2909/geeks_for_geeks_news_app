package com.example.geeks_for_eeks_news_app
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

const val BASEURL = "https://newsapi.org/"


object Retrofit_object {

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASEURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val NewsInterface= retrofit.create(News_Services::class.java)


}