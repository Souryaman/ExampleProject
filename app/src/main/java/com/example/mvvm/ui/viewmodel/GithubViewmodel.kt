package com.example.mvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.mvvm.data.model.Users
import com.example.mvvm.data.repository.GithubRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GithubViewmodel : ViewModel() {

    val users = MutableLiveData<List<Users>>()

    fun fetchUsers() {
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO) { GithubRepository.getUsers() }
            if (response.isSuccessful) {
                response.body()?.let {
                    users.postValue(it)
                }
            }
        }

    }

    fun searchUsers(name: String) = liveData(Dispatchers.IO) {
        val response = withContext(Dispatchers.IO) { GithubRepository.searchUsers(name) }
        if (response.isSuccessful) {
            response.body()?.let {
                emit(it.items)
            }


        }
    }
}


