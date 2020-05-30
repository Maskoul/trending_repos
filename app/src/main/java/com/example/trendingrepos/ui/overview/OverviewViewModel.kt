package com.example.trendingrepos.ui.overview

import androidx.lifecycle.ViewModel
import com.example.trendingrepos.repository.TrendingRepoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class OverviewViewModel(private val repository: TrendingRepoRepository) : ViewModel() {

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        uiScope.launch {
            repository.refreshRepos()
        }
    }

    val results = repository.repositories
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
