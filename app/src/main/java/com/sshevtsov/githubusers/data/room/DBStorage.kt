package com.sshevtsov.githubusers.data.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    exportSchema = true,
    entities = [RoomGitHubUser::class, RoomGitHubRepository::class],
    version = 1
)
abstract class DBStorage : RoomDatabase() {

    abstract fun gitHubUserDao(): GitHubUserDao

    abstract fun gitHubRepositoryDao(): GitHubRepositoryDao

}