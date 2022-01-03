package com.sshevtsov.githubusers.di

import com.sshevtsov.githubusers.data.mappers.GitHubUserRetrofitMapper
import com.sshevtsov.githubusers.data.mappers.GitHubUserRetrofitMapperImpl
import com.sshevtsov.githubusers.data.mappers.GitHubUserRoomMapper
import com.sshevtsov.githubusers.data.mappers.GitHubUserRoomMapperImpl
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