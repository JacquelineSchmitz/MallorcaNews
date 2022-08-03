package com.example.myapplicationnews.data.model

data class NewsArticle(
    val id: Int,
    val title: String,
    val imageResourceId: Int,
    val location: String,
    val date: String,
    val story: String
)