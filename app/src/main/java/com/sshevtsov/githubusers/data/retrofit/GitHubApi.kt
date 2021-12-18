package com.sshevtsov.githubusers.data.retrofit

import com.sshevtsov.githubusers.data.remote.GitHubRepoDto
import com.sshevtsov.githubusers.data.remote.GitHubUserDto
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApi {

    @GET("/users")
    fun getUsers(): Single<List<GitHubUserDto>>

    @GET("/users/{login}")
    fun getUserByLogin(@Path("login") login: String): Single<GitHubUserDto>

    @GET("/users/{login}/repos")
    fun getUserRepositories(@Path("login") login: String): Single<List<GitHubRepoDto>>

}