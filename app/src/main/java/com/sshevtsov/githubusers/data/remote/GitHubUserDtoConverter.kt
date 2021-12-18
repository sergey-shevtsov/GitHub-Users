package com.sshevtsov.githubusers.data.remote

import com.sshevtsov.githubusers.data.entities.GitHubRepo
import com.sshevtsov.githubusers.data.entities.GitHubUser

object GitHubUserDtoConverter {

    fun convertUserDto(userDto: GitHubUserDto): GitHubUser {
        with(userDto) {
            return GitHubUser(
                id = id,
                login = login,
                avatarUrl = avatarUrl,
                htmlUrl = htmlUrl,
                reposUrl = reposUrl
            )
        }
    }

    fun convertRepoDto(repoDto: GitHubRepoDto): GitHubRepo {
        with(repoDto) {
            return GitHubRepo(
                id = id,
                name = name,
                htmlUrl = htmlUrl,
                language = language,
                stargazersCount = stargazersCount
            )
        }
    }

    fun convertUserDtoList(userDtoList: List<GitHubUserDto>): List<GitHubUser> {
        return userDtoList.map { convertUserDto(it) }
    }

    fun convertRepoDtoList(repoDtoList: List<GitHubRepoDto>): List<GitHubRepo> {
        return repoDtoList.map { convertRepoDto(it) }
    }

}