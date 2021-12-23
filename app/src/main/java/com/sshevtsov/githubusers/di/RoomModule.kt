package com.sshevtsov.githubusers.di

import android.content.Context
import androidx.room.Room
import com.sshevtsov.githubusers.data.room.DBStorage
import com.sshevtsov.githubusers.data.room.GitHubRepositoryDao
import com.sshevtsov.githubusers.data.room.GitHubUserDao
import com.sshevtsov.githubusers.data.room.Migrations
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Singleton
    @Provides
    fun database(context: Context): DBStorage =
        Room.databaseBuilder(context, DBStorage::class.java, "github.db")
            .addMigrations(Migrations.MIGRATION_1_2)
            .build()

    @Provides
    fun roomUserDao(context: Context): GitHubUserDao =
        database(context).gitHubUserDao()

    @Provides
    fun roomRepositoryDao(context: Context): GitHubRepositoryDao =
        database(context).gitHubRepositoryDao()

}