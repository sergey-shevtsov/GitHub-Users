package com.sshevtsov.githubusers.data.repository

import com.sshevtsov.githubusers.data.entities.GitHubRepositoryEntity
import io.reactivex.rxjava3.core.Single

interface GitHubRepoRepository {

    fun getUserRepositories(login: String): Single<List<GitHubRepositoryEntity>>

}