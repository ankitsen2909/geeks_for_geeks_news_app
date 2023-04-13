package com.example.geeks_for_eeks_news_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getNews()
    }

    fun getNews(){

        val news=Retrofit_object.NewsInterface.get_headline("in",1,"sports")
        news.enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val recyclerView=findViewById<RecyclerView>(R.id.recyclerview)
                if (response.body() != null) {
                    recyclerView.adapter=NewsAdapter(response.body()!!.articles,this@MainActivity)
                    recyclerView.layoutManager=LinearLayoutManager(this@MainActivity)
                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("Ankit","Error",t)
            }
        })
    }
}