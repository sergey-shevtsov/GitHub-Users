package com.sshevtsov.githubusers.di

import com.sshevtsov.githubusers.data.mappers.GitHubUserRetrofitMapper
import com.sshevtsov.githubusers.data.mappers.GitHubUserRetrofitMapperImpl
import dagger.Module
import dagger.Provides

@Module
class MappersModule {

    @Provides
    fun provideGitHubUserRetrofitMapper(): GitHubUserRetrofitMapper =
        GitHubUserRetrofitMapperImpl()

}