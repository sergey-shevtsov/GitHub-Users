package com.sshevtsov.githubusers.data.remote

import com.sshevtsov.githubusers.data.entities.GitHubRepoEntity
import com.sshevtsov.githubusers.data.entities.GitHubUserEntity
import io.reactivex.rxjava3.core.Single

interface GitHubUserRepository {

    fun getUsers(): Single<List<GitHubUserEntity>>

    fun getUserByLogin(login: String): Single<GitHubUserEntity>

    fun getUserRepositories(login: String): Single<List<GitHubRepoEntity>>

}