package com.sshevtsov.githubusers.data.mappers.interfaces

import com.sshevtsov.githubusers.data.entities.GitHubUserEntity
import com.sshevtsov.githubusers.data.room.RoomGitHubUser

interface GitHubUserRoomMapper {

    fun mapToRoomUser(user: GitHubUserEntity): RoomGitHubUser

    fun mapToRoomUser(users: List<GitHubUserEntity>): List<RoomGitHubUser>

    fun mapToUser(roomUser: RoomGitHubUser): GitHubUserEntity

    fun mapToUser(roomUsers: List<RoomGitHubUser>): List<GitHubUserEntity>

}