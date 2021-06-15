package com.nab.photolistappreplicon.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nab.photolistappreplicon.databinding.PhotoItemBinding
import com.nab.photolistappreplicon.models.PhotoItem

class MainAdapter: RecyclerView.Adapter<MainViewHolder>() {

    var photos = mutableListOf<PhotoItem>()

    fun setPhotoList(photos: List<PhotoItem>) {
        this.photos = photos.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = PhotoItemBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val photos = photos[position]
        holder.binding.name.text = photos.title
        Glide.with(holder.itemView.context).load(photos.thumbnailUrl+".jpg").into(holder.binding.imageview)
    }

    override fun getItemCount(): Int {
        return photos.size
    }
}

class MainViewHolder(val binding: PhotoItemBinding) : RecyclerView.ViewHolder(binding.root) {

}