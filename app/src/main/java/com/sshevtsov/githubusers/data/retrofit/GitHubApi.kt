package com.sshevtsov.githubusers.data.retrofit

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApi {

    @GET("/users")
    fun getUsers(): Single<List<RetrofitGitHubUser>>

    @GET("/users/{login}")
    fun getUserByLogin(@Path("login") login: String): Single<RetrofitGitHubUser>

    @GET("/users/{login}/repos")
    fun getUserRepositories(@Path("login") login: String): Single<List<RetrofitGitHubRepository>>

}