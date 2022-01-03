package com.sshevtsov.githubusers.data.room

import com.sshevtsov.githubusers.data.entities.GitHubRepositoryEntity
import com.sshevtsov.githubusers.data.entities.GitHubUserEntity

object RoomGitHubMapper {

    fun mapRoomRepositoryToRepositoryEntity(roomRepository: RoomGitHubRepository): GitHubRepositoryEntity {
        with(roomRepository) {
            return GitHubRepositoryEntity(id, name, htmlUrl, language, forksCount, stargazersCount)
        }
    }

    fun mapRoomRepositoryToRepositoryEntity(roomRepositories: List<RoomGitHubRepository>): List<GitHubRepositoryEntity> =
        roomRepositories.map { mapRoomRepositoryToRepositoryEntity(it) }

    fun mapRepositoryEntityToRoomRepository(
        repositoryEntity: GitHubRepositoryEntity,
        userId: String
    ): RoomGitHubRepository {
        with(repositoryEntity) {
            return RoomGitHubRepository(
                id,
                name,
                htmlUrl,
                language,
                forksCount,
                stargazersCount,
                userId
            )
        }
    }

    fun mapRepositoryEntityToRoomRepository(
        repositoryEntities: List<GitHubRepositoryEntity>,
        userId: String
    ): List<RoomGitHubRepository> =
        repositoryEntities.map { mapRepositoryEntityToRoomRepository(it, userId) }

}