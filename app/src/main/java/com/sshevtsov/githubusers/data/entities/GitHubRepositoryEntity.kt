package com.sshevtsov.githubusers.data.entities

data class GitHubRepositoryEntity(
    val id: String,
    val name: String,
    val htmlUrl: String,
    val language: String,
    val forksCount: String,
    val stargazersCount: String
)