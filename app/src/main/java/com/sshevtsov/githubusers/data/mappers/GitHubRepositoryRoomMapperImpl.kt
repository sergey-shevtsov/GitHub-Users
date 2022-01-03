package com.sshevtsov.githubusers.data.mappers

import com.sshevtsov.githubusers.data.entities.GitHubRepositoryEntity
import com.sshevtsov.githubusers.data.room.RoomGitHubRepository

class GitHubRepositoryRoomMapperImpl : GitHubRepositoryRoomMapper {

    override fun mapToRoomRepository(
        repository: GitHubRepositoryEntity,
        userId: String
    ): RoomGitHubRepository {
        with(repository) {
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

    override fun mapToRoomRepository(
        repositories: List<GitHubRepositoryEntity>,
        userId: String
    ): List<RoomGitHubRepository> =
        repositories.map { mapToRoomRepository(it, userId) }

    override fun mapToRepository(
        roomRepository: RoomGitHubRepository
    ): GitHubRepositoryEntity {
        with(roomRepository) {
            return GitHubRepositoryEntity(
                id,
                name,
                htmlUrl,
                language,
                forksCount,
                stargazersCount
            )
        }
    }

    override fun mapToRepository(
        roomRepositories: List<RoomGitHubRepository>
    ): List<GitHubRepositoryEntity> =
        roomRepositories.map { mapToRepository(it) }

}