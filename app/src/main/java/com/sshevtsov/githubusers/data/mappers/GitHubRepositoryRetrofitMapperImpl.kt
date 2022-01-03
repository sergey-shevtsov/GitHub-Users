package com.sshevtsov.githubusers.data.mappers

import com.sshevtsov.githubusers.data.entities.GitHubRepositoryEntity
import com.sshevtsov.githubusers.data.retrofit.RetrofitGitHubRepository

class GitHubRepositoryRetrofitMapperImpl : GitHubRepositoryRetrofitMapper {

    override fun map(repository: RetrofitGitHubRepository): GitHubRepositoryEntity {

        with(repository) {
            return GitHubRepositoryEntity(
                id = id ?: "",
                name = name ?: "",
                htmlUrl = htmlUrl ?: "",
                language = language ?: "",
                forksCount = forksCount ?: "",
                stargazersCount = stargazersCount ?: ""
            )
        }

    }

    override fun map(repositories: List<RetrofitGitHubRepository>): List<GitHubRepositoryEntity> =
        repositories.map { map(it) }

}