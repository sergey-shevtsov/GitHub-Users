package com.sshevtsov.githubusers.data.repository

import com.sshevtsov.githubusers.data.entities.GitHubUserEntity
import com.sshevtsov.githubusers.data.mappers.GitHubUserRetrofitMapper
import com.sshevtsov.githubusers.data.mappers.GitHubUserRoomMapper
import com.sshevtsov.githubusers.data.retrofit.GitHubApi
import com.sshevtsov.githubusers.data.room.GitHubUserDao
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class GitHubUserRepositoryImpl
@Inject constructor(
    private val gitHubApi: GitHubApi,
    private val roomUserDao: GitHubUserDao,
    private val retrofitUserMapper: GitHubUserRetrofitMapper,
    private val roomUserMapper: GitHubUserRoomMapper
) : GitHubUserRepository {

    override fun getUsers(): Single<List<GitHubUserEntity>> {
        return roomUserDao.getAll()
            .flatMap {
                if (it.isEmpty()) {
                    gitHubApi.getUsers()
                        .map { resultFromServer ->
                            val users = retrofitUserMapper.map(resultFromServer)
                            roomUserDao.insert(roomUserMapper.mapToRoomUser(users))
                            users
                        }
                } else {
                    Single.just(roomUserMapper.mapToUser(it))
                }
            }
            .subscribeOn(Schedulers.io())
    }

    override fun getUserByLogin(login: String): Single<GitHubUserEntity> {
        return roomUserDao.findByLogin(login)
            .flatMap { Single.just(roomUserMapper.mapToUser(it)) }
            .subscribeOn(Schedulers.io())
    }
}