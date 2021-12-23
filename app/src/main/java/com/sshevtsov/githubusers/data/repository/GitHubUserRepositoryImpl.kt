package com.sshevtsov.githubusers.data.repository

import com.sshevtsov.githubusers.data.entities.GitHubRepositoryEntity
import com.sshevtsov.githubusers.data.entities.GitHubUserEntity
import com.sshevtsov.githubusers.data.retrofit.GitHubDtoMapper
import com.sshevtsov.githubusers.data.retrofit.GitHubApi
import com.sshevtsov.githubusers.data.room.GitHubRepositoryDao
import com.sshevtsov.githubusers.data.room.GitHubUserDao
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class GitHubUserRepositoryImpl(
    private val gitHubApi: GitHubApi,
    private val roomUserDao: GitHubUserDao,
    private val roomRepositoryDao: GitHubRepositoryDao
) : GitHubUserRepository {

    override fun getUsers(): Single<List<GitHubUserEntity>> {
        return gitHubApi.getUsers()
            .map { GitHubDtoMapper.mapUserDtoListToEntityList(it) }
            .subscribeOn(Schedulers.io())
    }

    override fun getUserByLogin(login: String): Single<GitHubUserEntity> {
        return gitHubApi.getUserByLogin(login)
            .map { GitHubDtoMapper.mapUserDtoToEntity(it) }
            .subscribeOn(Schedulers.io())
    }

    override fun getUserRepositories(login: String): Single<List<GitHubRepositoryEntity>> {
        return gitHubApi.getUserRepositories(login)
            .map { GitHubDtoMapper.mapRepoDtoListToEntityList(it) }
            .subscribeOn(Schedulers.io())
    }
}