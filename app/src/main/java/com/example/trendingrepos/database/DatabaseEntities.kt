package com.example.trendingrepos.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Repositories")
data class RepositoryDatabase(
    @PrimaryKey
    val id: Long,
    val title: String,
    val username: String,
    @ColumnInfo(name = "profile_picture")
    val profilePicture: String,
    val description: String,
    val stars: Int
)