package com.example.trendingrepos.work

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.trendingrepos.database.RepositoryRoomDatabase
import com.example.trendingrepos.repository.TrendingRepoRepository
import retrofit2.HttpException

class RefreshDataWork(appContext: Context, prams: WorkerParameters) :
    CoroutineWorker(appContext, prams) {

    companion object {
        const val WORK_NAME = "RefreshDataWorker"
    }

    override suspend fun doWork(): Result {
        val database = RepositoryRoomDatabase.getInstance(applicationContext)
        val trendingRepoRepository = TrendingRepoRepository(database)
        return try {
            trendingRepoRepository.refreshRepos()
            Result.success()
        } catch (e: HttpException) {
            Result.retry()
        }
    }

}