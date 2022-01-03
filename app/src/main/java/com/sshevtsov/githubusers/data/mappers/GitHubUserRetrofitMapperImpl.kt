package com.sshevtsov.githubusers.data.mappers

import com.sshevtsov.githubusers.data.entities.GitHubUserEntity
import com.sshevtsov.githubusers.data.retrofit.RetrofitGitHubUser

class GitHubUserRetrofitMapperImpl : GitHubUserRetrofitMapper {

    override fun map(user: RetrofitGitHubUser): GitHubUserEntity {

        with(user) {
            return GitHubUserEntity(
                id = id ?: "",
                login = login ?: "",
                avatarUrl = avatarUrl ?: "",
                htmlUrl = htmlUrl ?: "",
                reposUrl = reposUrl ?: ""
            )
        }

    }

    override fun map(users: List<RetrofitGitHubUser>): List<GitHubUserEntity> =
        users.map { map(it) }

}