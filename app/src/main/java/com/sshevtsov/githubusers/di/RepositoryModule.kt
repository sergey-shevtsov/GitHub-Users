package com.sshevtsov.githubusers.di

import com.sshevtsov.githubusers.data.mappers.interfaces.GitHubUserRetrofitMapper
import com.sshevtsov.githubusers.data.mappers.interfaces.GitHubUserRoomMapper
import com.sshevtsov.githubusers.data.repository.GitHubUserRepository
import com.sshevtsov.githubusers.data.repository.GitHubUserRepositoryImpl
import com.sshevtsov.githubusers.data.retrofit.GitHubApi
import com.sshevtsov.githubusers.data.room.GitHubUserDao
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun userRepository(
        api: GitHubApi,
        roomUserDao: GitHubUserDao,
        retrofitMapper: GitHubUserRetrofitMapper,
        roomUserMapper: GitHubUserRoomMapper
    ): GitHubUserRepository =
        GitHubUserRepositoryImpl(api, roomUserDao, retrofitMapper, roomUserMapper)

}