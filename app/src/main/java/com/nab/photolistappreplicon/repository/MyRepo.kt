package com.nab.photolistappreplicon.repository

import com.nab.photolistappreplicon.retrofit.ApiInterface

class MyRepo constructor(private val retrofitService: ApiInterface)  {
    fun getAllPhotos() = retrofitService.getPhotoAPI()

}