package com.sshevtsov.githubusers.data.remote

import com.sshevtsov.githubusers.data.entities.GitHubRepoEntity
import com.sshevtsov.githubusers.data.entities.GitHubUserEntity
import com.sshevtsov.githubusers.data.retrofit.GitHubApi
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class GitHubUserRepositoryImpl(
    private val gitHubApi: GitHubApi
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

    override fun getUserRepositories(login: String): Single<List<GitHubRepoEntity>> {
        return gitHubApi.getUserRepositories(login)
            .map { GitHubDtoMapper.mapRepoDtoListToEntityList(it) }
            .subscribeOn(Schedulers.io())
    }
}