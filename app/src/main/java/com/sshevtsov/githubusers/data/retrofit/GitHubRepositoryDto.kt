package com.sshevtsov.githubusers.data.retrofit

import com.google.gson.annotations.SerializedName

data class GitHubRepositoryDto(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("html_url")
    val htmlUrl: String? = null,
    @SerializedName("language")
    val language: String? = null,
    @SerializedName("forks_count")
    val forksCount: String? = null,
    @SerializedName("stargazers_count")
    val stargazersCount: String? = null
)