package com.nab.photolistappreplicon.retrofit

import com.nab.photolistappreplicon.models.PhotoItem
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {
    @GET("photos")
    fun getPhotoAPI() : Call<List<PhotoItem>>

    companion object {

        var retrofitService: ApiInterface? = null

        fun getInstance() : ApiInterface {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(ApiInterface::class.java)
            }
            return retrofitService!!
        }
    }
}