package com.sshevtsov.githubusers.data.mappers.impl

import com.sshevtsov.githubusers.data.entities.GitHubUserEntity
import com.sshevtsov.githubusers.data.mappers.interfaces.GitHubUserRoomMapper
import com.sshevtsov.githubusers.data.room.RoomGitHubUser

class GitHubUserRoomMapperImpl : GitHubUserRoomMapper {

    override fun mapToRoomUser(user: GitHubUserEntity): RoomGitHubUser {
        with(user) {
            return RoomGitHubUser(id, login, avatarUrl, htmlUrl, reposUrl)
        }
    }

    override fun mapToRoomUser(users: List<GitHubUserEntity>): List<RoomGitHubUser> =
        users.map { mapToRoomUser(it) }

    override fun mapToUser(roomUser: RoomGitHubUser): GitHubUserEntity {
        with(roomUser) {
            return GitHubUserEntity(id, login, avatarUrl, htmlUrl, reposUrl)
        }
    }

    override fun mapToUser(roomUsers: List<RoomGitHubUser>): List<GitHubUserEntity> =
        roomUsers.map { mapToUser(it) }

}