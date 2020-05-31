package com.example.trendingrepos.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.trendingrepos.domain.Repository

class DetailViewModel(repository: Repository) : ViewModel() {

    private val _repository = MutableLiveData<Repository>()
    val repository: LiveData<Repository>
        get() = _repository

    init {
        _repository.value = repository
    }
}