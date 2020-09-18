package com.example.newsapikotlin.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.newsapikotlin.model.ApiModel
import com.example.newsapikotlin.model.Articles
import com.example.newsapikotlin.rest.NewsApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import java.lang.Exception

class NewsApiModel(application: Application) : AndroidViewModel(application) {

    private val compositeDisposable = CompositeDisposable()

    private val newsApiService = NewsApiService()

    val articles by lazy {
        MutableLiveData<List<Articles>>()
    }

    val loading by lazy {
        MutableLiveData<Boolean>()
    }

    val loadingError by lazy {
        MutableLiveData<Boolean>()
    }


    public fun getNewsData()
    {

            compositeDisposable.add(
                newsApiService.getNewsAPi().subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(object : DisposableSingleObserver<ApiModel>(){
                        override fun onSuccess(apimodel : ApiModel) {

                            articles.postValue(apimodel.articles)
                            Log.e("apidata",apimodel.articles.toString())
                        }

                        override fun onError(e: Throwable) {

                            Log.e("error",e.message.toString())
                        }

                    })
            )

    }


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}