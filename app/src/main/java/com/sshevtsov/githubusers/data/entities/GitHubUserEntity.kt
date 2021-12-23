package com.sshevtsov.githubusers.data.entities

data class GitHubUserEntity(
    val id: String,
    val login: String,
    val avatarUrl: String,
    val htmlUrl: String,
    val reposUrl: String
)