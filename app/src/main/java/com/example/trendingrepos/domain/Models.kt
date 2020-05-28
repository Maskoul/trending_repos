package com.example.trendingrepos.domain

data class Repository(
    val id: Long,
    val title: String,
    val userName: String,
    val profilePicture: String,
    val description: String,
    val stars: Int
)