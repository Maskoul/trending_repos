package com.example.trendingrepos.ui.overview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.trendingrepos.repository.TrendingRepoRepository


class OverviewViewModelFactory(private val repository: TrendingRepoRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OverviewViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return OverviewViewModel(repository) as T
        }
        throw IllegalArgumentException("Unable to construct viewmodel")
    }
}
