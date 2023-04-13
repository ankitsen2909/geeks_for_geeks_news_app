package com.example.geeks_for_eeks_news_app

data class News(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)