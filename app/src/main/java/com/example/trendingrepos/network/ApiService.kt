package com.example.trendingrepos.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


private const val GITHUB_BASE_URL =
    "https://api.github.com"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


interface GithubRepoService {

    @GET("search/repositories")
    suspend fun getTrendingRepos(
        @Query("q") queryTime: String,
        @Query("sort") sort: String,
        @Query("order") order: String
    ):
            Response<NetworkRepositoryContainer>
}

private val retrofit = Retrofit.Builder().baseUrl(GITHUB_BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()


object Network {

    val retrofitService: GithubRepoService by lazy {
        retrofit.create(GithubRepoService::class.java)
    }
}
