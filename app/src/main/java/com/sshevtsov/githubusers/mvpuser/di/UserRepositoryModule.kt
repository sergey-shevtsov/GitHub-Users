package com.sshevtsov.githubusers.mvpuser.di

import com.sshevtsov.githubusers.data.mappers.GitHubRepositoryRetrofitMapper
import com.sshevtsov.githubusers.data.mappers.GitHubRepositoryRoomMapper
import com.sshevtsov.githubusers.data.repository.GitHubRepoRepository
import com.sshevtsov.githubusers.data.repository.GitHubRepoRepositoryImpl
import com.sshevtsov.githubusers.data.retrofit.GitHubApi
import com.sshevtsov.githubusers.data.room.GitHubRepositoryDao
import com.sshevtsov.githubusers.data.room.GitHubUserDao
import dagger.Module
import dagger.Provides

@Module
class UserRepositoryModule {

    @UserScope
    @Provides
    fun repoRepository(
        api: GitHubApi,
        roomUserDao: GitHubUserDao,
        roomRepositoryDao: GitHubRepositoryDao,
        retrofitRepositoryMapper: GitHubRepositoryRetrofitMapper,
        roomRepositoryMapper: GitHubRepositoryRoomMapper
    ): GitHubRepoRepository =
        GitHubRepoRepositoryImpl(
            api,
            roomUserDao,
            roomRepositoryDao,
            retrofitRepositoryMapper,
            roomRepositoryMapper
        )

}