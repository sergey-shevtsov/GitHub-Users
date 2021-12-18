package com.sshevtsov.githubusers.data.remote

import com.sshevtsov.githubusers.data.entities.GitHubRepo
import com.sshevtsov.githubusers.data.entities.GitHubUser
import io.reactivex.rxjava3.core.Single

interface GitHubUserRepository {

    fun getUsers(): Single<List<GitHubUser>>

    fun getUserByLogin(login: String): Single<GitHubUser>

    fun getUserRepositories(login: String): Single<List<GitHubRepo>>

}