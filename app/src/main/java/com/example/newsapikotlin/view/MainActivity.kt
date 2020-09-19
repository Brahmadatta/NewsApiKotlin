package com.example.newsapikotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapikotlin.R
import com.example.newsapikotlin.model.Articles
import com.example.newsapikotlin.viewmodel.NewsApiModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var newsApiModel: NewsApiModel
    private val linearLayoutManager : LinearLayoutManager ?= null
    private val newsApiAdapter = NewsApiAdapter(arrayListOf())

    private val articleObserver = Observer<List<Articles>> { list ->
        list?.let {
            newsApiAdapter.updateNewsApiList(list as ArrayList<Articles>)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        newsApiModel = ViewModelProviders.of(this).get(NewsApiModel::class.java)
        newsApiModel.articles.observe(this, articleObserver)

        newsApiModel.getNewsData()

        news_recyclerView.setHasFixedSize(true)
        news_recyclerView.layoutManager = linearLayoutManager
        news_recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = newsApiAdapter
        }

    }



}