package com.example.trendingrepos.ui.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.trendingrepos.domain.Repository
import com.example.trendingrepos.repository.TrendingRepoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class OverviewViewModel(private val repository: TrendingRepoRepository) : ViewModel() {

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private val _naveToDetailEvent = MutableLiveData<Repository>()
    val naveToDetailEvent: LiveData<Repository>
        get() = _naveToDetailEvent

    init {
        uiScope.launch {
            repository.refreshRepos()
        }
    }

    val results = repository.repositories

    fun onNavigateToDetail(repository: Repository) {
        _naveToDetailEvent.value = repository
    }
    fun doneNavigateToDetail(){
        _naveToDetailEvent.value = null
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
