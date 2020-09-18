package com.example.newsapikotlin.rest

import com.example.newsapikotlin.model.ApiModel
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NewsApiService {

    private val BASE_URL = "http://newsapi.org/";

    val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(NewsApi::class.java)


    fun getNewsAPi() : Single<ApiModel>
    {
        return api.getNewsData()
    }
}