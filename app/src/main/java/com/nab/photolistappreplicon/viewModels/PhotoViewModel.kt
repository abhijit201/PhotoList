package com.nab.photolistappreplicon.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nab.photolistappreplicon.models.PhotoItem
import com.nab.photolistappreplicon.repository.MyRepo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PhotoViewModel constructor(private val repository: MyRepo)  : ViewModel() {

    val photoList = MutableLiveData<List<PhotoItem>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllPhotos() {

        val response = repository.getAllPhotos()
        response.enqueue(object : Callback<List<PhotoItem>> {
            override fun onResponse(call: Call<List<PhotoItem>>, response: Response<List<PhotoItem>>) {
                photoList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<PhotoItem>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}