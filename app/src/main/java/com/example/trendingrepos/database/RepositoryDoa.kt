package com.example.trendingrepos.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RepositoryDoa {

    @Query("SELECT * FROM Repositories ORDER BY stars DESC")
    fun getAllRepositories(): LiveData<List<RepositoryDatabase>>

    @Query("SELECT * FROM Repositories WHERE id =:repositoryId")
    fun getRepository(repositoryId: Long): RepositoryDatabase

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg repositories: RepositoryDatabase)
}