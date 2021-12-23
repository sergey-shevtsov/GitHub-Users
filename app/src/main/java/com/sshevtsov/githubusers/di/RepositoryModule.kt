package com.sshevtsov.githubusers.di

import com.sshevtsov.githubusers.data.repository.GitHubUserRepository
import com.sshevtsov.githubusers.data.repository.GitHubUserRepositoryImpl
import com.sshevtsov.githubusers.data.retrofit.GitHubApi
import com.sshevtsov.githubusers.data.room.GitHubRepositoryDao
import com.sshevtsov.githubusers.data.room.GitHubUserDao
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun userRepository(
        api: GitHubApi,
        roomUserDao: GitHubUserDao,
        roomRepositoryDao: GitHubRepositoryDao
    ): GitHubUserRepository =
        GitHubUserRepositoryImpl(api, roomUserDao, roomRepositoryDao)

}