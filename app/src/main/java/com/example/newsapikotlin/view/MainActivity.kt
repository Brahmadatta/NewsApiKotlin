package com.example.newsapikotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.newsapikotlin.R
import com.example.newsapikotlin.model.Articles
import com.example.newsapikotlin.viewmodel.NewsApiModel

class MainActivity : AppCompatActivity() {

    lateinit var newsApiModel : NewsApiModel


    private val articleObserver = Observer<List<Articles>>{
        list : List<Articles>? -> {
        Log.e("list",list.toString())
    }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        newsApiModel = ViewModelProviders.of(this).get(NewsApiModel::class.java)
        newsApiModel.articles.observe(this,articleObserver)

        newsApiModel.getNewsData()

    }
}