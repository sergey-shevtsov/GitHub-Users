package com.sshevtsov.githubusers.mvpuser.di

import com.sshevtsov.githubusers.data.mappers.GitHubRepositoryRetrofitMapper
import com.sshevtsov.githubusers.data.mappers.GitHubRepositoryRetrofitMapperImpl
import com.sshevtsov.githubusers.data.mappers.GitHubRepositoryRoomMapper
import com.sshevtsov.githubusers.data.mappers.GitHubRepositoryRoomMapperImpl
import dagger.Module
import dagger.Provides

@Module
class UserMappersModule {

    @UserScope
    @Provides
    fun provideGitHubRepositoryRetrofitMapper(): GitHubRepositoryRetrofitMapper =
        GitHubRepositoryRetrofitMapperImpl()

    @UserScope
    @Provides
    fun provideGitHubRepositoryRoomMapper(): GitHubRepositoryRoomMapper =
        GitHubRepositoryRoomMapperImpl()

}