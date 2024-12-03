// ui/home/HomeScreenAdapter.kt
package com.example.appblog.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appblog.data.model.Post
import com.example.appblog.databinding.PostItemViewBinding

class HomeScreenAdapter(private val postList: List<Post>) : RecyclerView.Adapter<HomeScreenAdapter.HomeScreenViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeScreenViewHolder {
        val itemBinding = PostItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeScreenViewHolder(itemBinding, parent.context)
    }

    override fun onBindViewHolder(holder: HomeScreenViewHolder, position: Int) {
        holder.bind(postList[position])
    }

    override fun getItemCount(): Int = postList.size

    inner class HomeScreenViewHolder(private val binding: PostItemViewBinding, private val context: Context) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Post) {
            Glide.with(context).load(item.post_image).centerCrop().into(binding.postImage)
            Glide.with(context).load(item.profile_picture).centerCrop().into(binding.profilePicture)
            binding.profileName.text = item.profile_name
            binding.postTimestamp.text = "Hace 2 horas"
        }
    }
}
