package com.sshevtsov.githubusers.data.remote

import com.google.gson.annotations.SerializedName

data class GitHubUserDto(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("login")
    val login: String? = null,
    @SerializedName("avatar_url")
    val avatarUrl: String? = null,
    @SerializedName("html_url")
    val htmlUrl: String? = null,
    @SerializedName("repos_url")
    val reposUrl: String? = null
)
