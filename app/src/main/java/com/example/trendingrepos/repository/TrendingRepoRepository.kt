package com.example.trendingrepos.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.trendingrepos.database.RepositoryRoomDatabase
import com.example.trendingrepos.database.asDomainModel
import com.example.trendingrepos.domain.Repository
import com.example.trendingrepos.network.Network
import com.example.trendingrepos.network.asDatabaseModel
import com.example.trendingrepos.util.getTimeQuery
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


private const val IN_LAST_30_DAYS = 30

class TrendingRepoRepository(private val roomDatabase: RepositoryRoomDatabase) {

    val repositories: LiveData<List<Repository>> =
        Transformations.map(roomDatabase.repositoryDoa.getAllRepositories()) {
            it.asDomainModel()
        }

    private val queryCreated = getTimeQuery(IN_LAST_30_DAYS)
    suspend fun refreshRepos() {
        withContext(Dispatchers.IO) {
            try {
                val reposList =
                    Network.retrofitService.getTrendingRepos(
                        queryCreated,
                        "stars",
                        "desc"
                    ).body()

                reposList?.let {
                    roomDatabase.repositoryDoa.insert(*it.asDatabaseModel())
                }


            } catch (e: Exception) {
                Log.e("error fetch data : ", "$e")
            }
        }
    }
}