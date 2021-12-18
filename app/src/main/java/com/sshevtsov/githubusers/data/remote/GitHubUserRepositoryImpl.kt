package com.sshevtsov.githubusers.data.remote

import com.sshevtsov.githubusers.data.entities.GitHubRepo
import com.sshevtsov.githubusers.data.entities.GitHubUser
import com.sshevtsov.githubusers.data.retrofit.GitHubApi
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class GitHubUserRepositoryImpl(
    private val gitHubApi: GitHubApi
) : GitHubUserRepository {

    override fun getUsers(): Single<List<GitHubUser>> {
        return gitHubApi.getUsers()
            .map { GitHubUserDtoConverter.convertUserDtoList(it) }
            .subscribeOn(Schedulers.io())
    }

    override fun getUserByLogin(login: String): Single<GitHubUser> {
        return gitHubApi.getUserByLogin(login)
            .map { GitHubUserDtoConverter.convertUserDto(it) }
            .subscribeOn(Schedulers.io())
    }

    override fun getUserRepositories(login: String): Single<List<GitHubRepo>> {
        return gitHubApi.getUserRepositories(login)
            .map { GitHubUserDtoConverter.convertRepoDtoList(it) }
            .subscribeOn(Schedulers.io())
    }
}