package com.example.trendingrepos.ui.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.trendingrepos.databinding.ListItemReposBinding
import com.example.trendingrepos.domain.Repository

class RepositoryAdapter : ListAdapter<Repository, RepositoryAdapter.MyViewHolder>(DiffCallBack) {

    companion object DiffCallBack : DiffUtil.ItemCallback<Repository>() {
        override fun areItemsTheSame(oldItem: Repository, newItem: Repository): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Repository, newItem: Repository): Boolean {
            return oldItem.id == newItem.id
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MyViewHolder(ListItemReposBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class MyViewHolder(private var binding: ListItemReposBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(repository: Repository) {
            binding.repositoryItem = repository
            binding.executePendingBindings()
        }
    }

}