package com.example.newsapikotlin.rest

import com.example.newsapikotlin.model.ApiModel
import io.reactivex.Single
import retrofit2.http.GET

interface NewsApi {

    @GET("http://newsapi.org/v2/everything?q=bitcoin&from=2020-08-18&sortBy=publishedAt&apiKey=eaa2024dc45f4e7f935a562a894c61b9")
    fun getNewsData() : Single<ApiModel>

}