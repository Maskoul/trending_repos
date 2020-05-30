package com.example.trendingrepos.network

import com.example.trendingrepos.database.RepositoryDatabase
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkRepositoryContainer(val items: List<NetworkRepositories>)

@JsonClass(generateAdapter = true)
data class NetworkRepositories(
    val id: Long,
    val name: String,
    val description: String,
    val owner: Owner,
    val stargazers_count: Int

) {
    data class Owner(
        val login: String,
        val avatar_url: String
    )
}

fun NetworkRepositoryContainer.asDatabaseModel(): Array<RepositoryDatabase> {
    return items.map {
        RepositoryDatabase(
            id = it.id,
            title = it.name,
            description = it.description,
            username = it.owner.login,
            profilePicture = it.owner.avatar_url,
            stars = it.stargazers_count
        )
    }.toTypedArray()
}