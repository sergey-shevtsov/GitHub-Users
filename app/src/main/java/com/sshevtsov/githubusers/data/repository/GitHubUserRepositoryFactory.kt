package com.sshevtsov.githubusers.data.repository

import com.sshevtsov.githubusers.data.retrofit.GitHubApiFactory

object GitHubUserRepositoryFactory {

    fun create(): GitHubUserRepository = GitHubUserRepositoryImpl(GitHubApiFactory.create())

}