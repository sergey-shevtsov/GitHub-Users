package com.sshevtsov.githubusers.data.remote

import com.sshevtsov.githubusers.data.retrofit.GitHubApiFactory

object GitHubUserRepositoryFactory {

    fun create(): GitHubUserRepository = GitHubUserRepositoryImpl(GitHubApiFactory.create())

}