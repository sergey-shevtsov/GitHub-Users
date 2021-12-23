package com.sshevtsov.githubusers.data.room

import androidx.room.*
import io.reactivex.rxjava3.core.Single

@Dao
interface GitHubUserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(repository: RoomGitHubUser)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg repositories: RoomGitHubUser)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(repositories: List<RoomGitHubUser>)

    @Update
    fun update(repository: RoomGitHubUser)

    @Update
    fun update(vararg repositories: RoomGitHubUser)

    @Update
    fun update(repositories: List<RoomGitHubUser>)

    @Delete
    fun delete(repository: RoomGitHubUser)

    @Delete
    fun delete(vararg repositories: RoomGitHubUser)

    @Delete
    fun delete(repositories: List<RoomGitHubUser>)

    @Query("SELECT * FROM GitHubUserTable")
    fun getAll(): Single<List<RoomGitHubUser>>

    @Query("SELECT * FROM GitHubUserTable WHERE login = :login LIMIT 1")
    fun findByLogin(login: String): Single<RoomGitHubUser>
}