package com.meleshko.flickrgallery

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.meleshko.flickrgallery.api.FlickrApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

class FlickrFetchr {

    private val flickrApi: FlickrApi

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://www.flickr.com/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()

        flickrApi = retrofit.create(FlickrApi::class.java)
    }

    fun fetchContent(): LiveData<String> {
        val responseLiveData: MutableLiveData<String> = MutableLiveData()
        val flickrRequest: Call<String> = flickrApi.fetchContents()

        flickrRequest.enqueue(object : Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.i("ZZZ", "onFailure: ")
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                Log.i("ZZZ", "onResponse: ${response.body()}")
                responseLiveData.value = response.body()
            }
        })
        return responseLiveData
    }
}