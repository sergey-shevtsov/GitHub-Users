package com.sshevtsov.githubusers.data.repository

import com.sshevtsov.githubusers.App
import com.sshevtsov.githubusers.data.retrofit.GitHubApiFactory

object GitHubUserRepositoryFactory {

    fun create(): GitHubUserRepository {
        return GitHubUserRepositoryImpl(
            GitHubApiFactory.create(),
            App.database.gitHubUserDao(),
            App.database.gitHubRepositoryDao()
        )
    }


}
