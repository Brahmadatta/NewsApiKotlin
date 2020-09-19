package com.example.newsapikotlin.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapikotlin.R
import com.example.newsapikotlin.model.Articles
import kotlinx.android.synthetic.main.news_item_layout.view.*

public class NewsApiAdapter(private val newsApiList : ArrayList<Articles>) : RecyclerView.Adapter<NewsApiAdapter.NewsApiViewHolder>() {


    fun updateNewsApiList(newList : ArrayList<Articles>)
    {
        newsApiList.clear()
        newsApiList.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsApiViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item_layout,parent,false)
        return NewsApiViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsApiViewHolder, position: Int) {


        holder.itemView.news_headline.text = newsApiList[position].author
        holder.itemView.news_description.text = newsApiList[position].description
        Glide.with(holder.itemView.news_image_id).load(newsApiList[position].urlToImage).into(holder.itemView.news_image_id)
    }

    override fun getItemCount(): Int {
        return newsApiList.size
    }

    public class NewsApiViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {


    }
}