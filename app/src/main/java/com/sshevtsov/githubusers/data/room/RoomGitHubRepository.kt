package com.sshevtsov.githubusers.data.room

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(
    tableName = "GitHubRepositoryTable",
    foreignKeys = [ForeignKey(
        entity = RoomGitHubUser::class,
        parentColumns = ["id"],
        childColumns = ["userId"],
        onDelete = CASCADE
    )]
)
data class RoomGitHubRepository(
    @PrimaryKey val id: String,
    val name: String,
    val htmlUrl: String,
    val language: String,
    val forksCount: String,
    val stargazersCount: String,
    val userId: String
)
