package com.sshevtsov.githubusers.data.repository

import com.sshevtsov.githubusers.data.entities.GitHubRepositoryEntity
import com.sshevtsov.githubusers.data.entities.GitHubUserEntity
import io.reactivex.rxjava3.core.Single

interface GitHubUserRepository {

    fun getUsers(): Single<List<GitHubUserEntity>>

    fun getUserByLogin(login: String): Single<GitHubUserEntity>

    fun getUserRepositories(login: String): Single<List<GitHubRepositoryEntity>>

}