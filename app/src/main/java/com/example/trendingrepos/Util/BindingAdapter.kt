package com.example.trendingrepos.Util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.trendingrepos.domain.Repository
import com.example.trendingrepos.ui.overview.RepositoryAdapter

@BindingAdapter("repositoryList")
fun RecyclerView.bindRecyclerView(repository: List<Repository>?) {
    val adapter = this.adapter as RepositoryAdapter
    adapter.submitList(repository)
}

@BindingAdapter("titleText")
fun TextView.bindTitleText(repository: Repository) {
    this.text = repository.title
}

@BindingAdapter("descriptionText")
fun TextView.bindDescriptionText(repository: Repository) {
    this.text = repository.description
}

@BindingAdapter("usernameText")
fun TextView.bindUsernameText(repository: Repository) {
    this.text = repository.username
}

@BindingAdapter("starsCountText")
fun TextView.bindStarsCountText(repository: Repository) {
    this.text = repository.stars.toString()
}

@BindingAdapter("profileImage")
fun ImageView.bindprofileImg(repository: Repository) {
    Glide.with(this.context)
        .load(repository.profilePicture)
        .into(this)
}