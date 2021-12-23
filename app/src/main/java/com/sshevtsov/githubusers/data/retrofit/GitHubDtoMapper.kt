package com.sshevtsov.githubusers.data.retrofit

import com.sshevtsov.githubusers.data.entities.GitHubRepositoryEntity
import com.sshevtsov.githubusers.data.entities.GitHubUserEntity

object GitHubDtoMapper {

    fun mapUserDtoToEntity(userDto: GitHubUserDto): GitHubUserEntity {
        with(userDto) {
            return GitHubUserEntity(
                id = id ?: "",
                login = login ?: "",
                avatarUrl = avatarUrl ?: "",
                htmlUrl = htmlUrl ?: "",
                reposUrl = reposUrl ?: ""
            )
        }
    }

    fun mapRepoDtoToEntity(repositoryDto: GitHubRepositoryDto): GitHubRepositoryEntity {
        with(repositoryDto) {
            return GitHubRepositoryEntity(
                id = id ?: "",
                name = name ?: "",
                htmlUrl = htmlUrl ?: "",
                language = language ?: "",
                forksCount = forksCount ?: "",
                stargazersCount = stargazersCount ?: ""
            )
        }
    }

    fun mapUserDtoListToEntityList(userDtoList: List<GitHubUserDto>): List<GitHubUserEntity> {
        return userDtoList.map { mapUserDtoToEntity(it) }
    }

    fun mapRepoDtoListToEntityList(repositoryDtoList: List<GitHubRepositoryDto>): List<GitHubRepositoryEntity> {
        return repositoryDtoList.map { mapRepoDtoToEntity(it) }
    }

}