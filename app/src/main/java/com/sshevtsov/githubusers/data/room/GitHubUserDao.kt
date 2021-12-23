package com.sshevtsov.githubusers.data.room

import androidx.room.*
import io.reactivex.rxjava3.core.Single

@Dao
interface GitHubUserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: RoomGitHubUser)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg users: RoomGitHubUser)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(users: List<RoomGitHubUser>)

    @Update
    fun update(user: RoomGitHubUser)

    @Update
    fun update(vararg users: RoomGitHubUser)

    @Update
    fun update(users: List<RoomGitHubUser>)

    @Delete
    fun delete(user: RoomGitHubUser)

    @Delete
    fun delete(vararg users: RoomGitHubUser)

    @Delete
    fun delete(users: List<RoomGitHubUser>)

    @Query("SELECT * FROM GitHubUserTable")
    fun getAll(): Single<List<RoomGitHubUser>>

    @Query("SELECT * FROM GitHubUserTable WHERE login = :login LIMIT 1")
    fun findByLogin(login: String): Single<RoomGitHubUser>
}