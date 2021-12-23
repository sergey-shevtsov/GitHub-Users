package com.sshevtsov.githubusers.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "GitHubUserTable")
data class RoomGitHubUser(
    @PrimaryKey val id: String,
    val login: String,
    val avatarUrl: String,
    val htmlUrl: String,
    val reposUrl: String
)
