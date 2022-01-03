package com.sshevtsov.githubusers.data.mappers

import com.sshevtsov.githubusers.data.entities.GitHubRepositoryEntity
import com.sshevtsov.githubusers.data.retrofit.RetrofitGitHubRepository

interface GitHubRepositoryRetrofitMapper {

    fun map(repository: RetrofitGitHubRepository): GitHubRepositoryEntity

    fun map(repositories: List<RetrofitGitHubRepository>): List<GitHubRepositoryEntity>

}