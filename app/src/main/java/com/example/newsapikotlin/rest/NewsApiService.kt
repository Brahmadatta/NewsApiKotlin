package com.example.newsapikotlin.rest

import com.example.newsapikotlin.model.ApiModel
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class NewsApiService {

    private val BASE_URL = "http://newsapi.org/"

    private val APIKEY = "eaa2024dc45f4e7f935a562a894c61b9"

    var cc = Calendar.getInstance()
    var year = cc[Calendar.YEAR]
    var month = cc[Calendar.MONTH]
    var mDay = cc[Calendar.DAY_OF_MONTH]

    val currentDate = "$year-$month-$mDay"

//    val currentDate: String = java.text.SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(
//        Date()
//    )


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

    fun getNewsApiData() : Single<ApiModel>
    {
        return api.getNewsDataa("bitcoin", currentDate, "publishedAt", APIKEY)
    }
}