package com.sshevtsov.githubusers.data.mappers.interfaces

import com.sshevtsov.githubusers.data.entities.GitHubRepositoryEntity
import com.sshevtsov.githubusers.data.room.RoomGitHubRepository

interface GitHubRepositoryRoomMapper {

    fun mapToRoomRepository(
        repository: GitHubRepositoryEntity,
        userId: String
    ): RoomGitHubRepository

    fun mapToRoomRepository(
        repositories: List<GitHubRepositoryEntity>,
        userId: String
    ): List<RoomGitHubRepository>

    fun mapToRepository(roomRepository: RoomGitHubRepository): GitHubRepositoryEntity

    fun mapToRepository(roomRepositories: List<RoomGitHubRepository>): List<GitHubRepositoryEntity>

}