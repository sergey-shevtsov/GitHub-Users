package com.sshevtsov.githubusers.di

import com.sshevtsov.githubusers.data.mappers.interfaces.GitHubUserRetrofitMapper
import com.sshevtsov.githubusers.data.mappers.impl.GitHubUserRetrofitMapperImpl
import com.sshevtsov.githubusers.data.mappers.interfaces.GitHubUserRoomMapper
import com.sshevtsov.githubusers.data.mappers.impl.GitHubUserRoomMapperImpl
import dagger.Module
import dagger.Provides

@Module
class MappersModule {

    @Provides
    fun provideGitHubUserRetrofitMapper(): GitHubUserRetrofitMapper =
        GitHubUserRetrofitMapperImpl()

    @Provides
    fun provideGitHubUserRoomMapper(): GitHubUserRoomMapper =
        GitHubUserRoomMapperImpl()

}