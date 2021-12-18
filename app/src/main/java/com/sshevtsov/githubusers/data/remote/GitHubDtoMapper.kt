package com.sshevtsov.githubusers.data.remote

import com.sshevtsov.githubusers.data.entities.GitHubRepoEntity
import com.sshevtsov.githubusers.data.entities.GitHubUserEntity

object GitHubDtoMapper {

    fun mapUserDtoToEntity(userDto: GitHubUserDto): GitHubUserEntity {
        with(userDto) {
            return GitHubUserEntity(
                id = id,
                login = login,
                avatarUrl = avatarUrl,
                htmlUrl = htmlUrl,
                reposUrl = reposUrl
            )
        }
    }

    fun mapRepoDtoToEntity(repoDto: GitHubRepoDto): GitHubRepoEntity {
        with(repoDto) {
            return GitHubRepoEntity(
                id = id,
                name = name,
                htmlUrl = htmlUrl,
                language = language,
                forksCount = forksCount,
                stargazersCount = stargazersCount
            )
        }
    }

    fun mapUserDtoListToEntityList(userDtoList: List<GitHubUserDto>): List<GitHubUserEntity> {
        return userDtoList.map { mapUserDtoToEntity(it) }
    }

    fun mapRepoDtoListToEntityList(repoDtoList: List<GitHubRepoDto>): List<GitHubRepoEntity> {
        return repoDtoList.map { mapRepoDtoToEntity(it) }
    }

}