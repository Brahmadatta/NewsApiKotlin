package com.example.newsapikotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import com.bumptech.glide.Glide
import com.example.newsapikotlin.R
import kotlinx.android.synthetic.main.activity_news_description.*
import kotlinx.android.synthetic.main.news_item_layout.*

class NewsDescriptionActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_description)




        if (intent.extras != null)
        {

            //news_api_text.text = intent?.extras?.getString("news_title")
            val image = intent?.extras?.getString("news_api_image")
            Glide.with(collapsingToolbar_news_image).load(image.toString()).into(collapsingToolbar_news_image)
            news_description_text.text = intent?.extras?.getString("news_description")
            supportActionBar?.title = intent?.extras?.getString("news_title")
            news_api_text.gravity = Gravity.START
        }

    }

}