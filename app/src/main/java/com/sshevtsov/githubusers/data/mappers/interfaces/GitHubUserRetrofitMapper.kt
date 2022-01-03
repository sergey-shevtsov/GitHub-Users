package com.sshevtsov.githubusers.data.mappers.interfaces

import com.sshevtsov.githubusers.data.entities.GitHubUserEntity
import com.sshevtsov.githubusers.data.retrofit.RetrofitGitHubUser

interface GitHubUserRetrofitMapper {

    fun map(user: RetrofitGitHubUser): GitHubUserEntity

    fun map(users: List<RetrofitGitHubUser>): List<GitHubUserEntity>

}