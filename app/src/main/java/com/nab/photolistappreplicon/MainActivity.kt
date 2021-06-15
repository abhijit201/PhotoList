package com.nab.photolistappreplicon

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.nab.photolistappreplicon.databinding.ActivityMainBinding
import com.nab.photolistappreplicon.recyclerView.MainAdapter
import com.nab.photolistappreplicon.repository.MyRepo
import com.nab.photolistappreplicon.repository.MyViewModelFactory
import com.nab.photolistappreplicon.retrofit.ApiInterface
import com.nab.photolistappreplicon.viewModels.PhotoViewModel

class MainActivity : AppCompatActivity() {

    lateinit var context: Context
    lateinit var viewModel: PhotoViewModel

    private lateinit var binding: ActivityMainBinding
    private val retrofitService = ApiInterface.getInstance()
    val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, MyViewModelFactory(MyRepo(retrofitService))).get(PhotoViewModel::class.java)

        binding.recyclerview.adapter = adapter

        viewModel.photoList.observe(this, Observer {
            Log.d("TAG", "onCreate: $it")
            adapter.setPhotoList(it)
        })

        viewModel.errorMessage.observe(this, Observer {

        })
        viewModel.getAllPhotos()
    }
}