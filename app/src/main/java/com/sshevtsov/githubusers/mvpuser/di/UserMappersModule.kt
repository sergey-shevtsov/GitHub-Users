package com.sshevtsov.githubusers.mvpuser.di

import com.sshevtsov.githubusers.data.mappers.interfaces.GitHubRepositoryRetrofitMapper
import com.sshevtsov.githubusers.data.mappers.impl.GitHubRepositoryRetrofitMapperImpl
import com.sshevtsov.githubusers.data.mappers.interfaces.GitHubRepositoryRoomMapper
import com.sshevtsov.githubusers.data.mappers.impl.GitHubRepositoryRoomMapperImpl
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