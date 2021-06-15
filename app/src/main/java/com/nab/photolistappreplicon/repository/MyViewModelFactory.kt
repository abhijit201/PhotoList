package com.nab.photolistappreplicon.repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nab.photolistappreplicon.viewModels.PhotoViewModel

class MyViewModelFactory constructor(private val repository: MyRepo): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(PhotoViewModel::class.java)) {
            PhotoViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}