package com.example.trendingrepos.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.trendingrepos.domain.Repository


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

fun List<RepositoryDatabase>.asDomainModel(): List<Repository> {
    return map {
        Repository(
            id = it.id,
            title = it.title,
            description = it.description,
            username = it.username,
            profilePicture = it.profilePicture,
            stars = it.stars
        )
    }
}