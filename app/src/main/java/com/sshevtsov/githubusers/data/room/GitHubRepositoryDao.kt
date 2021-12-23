package com.sshevtsov.githubusers.data.room

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import io.reactivex.rxjava3.core.Single

@Dao
interface GitHubRepositoryDao {

    @Insert(onConflict = REPLACE)
    fun insert(repository: RoomGitHubRepository)

    @Insert(onConflict = REPLACE)
    fun insert(vararg repositories: RoomGitHubRepository)

    @Insert(onConflict = REPLACE)
    fun insert(repositories: List<RoomGitHubRepository>)

    @Update
    fun update(repository: RoomGitHubRepository)

    @Update
    fun update(vararg repositories: RoomGitHubRepository)

    @Update
    fun update(repositories: List<RoomGitHubRepository>)

    @Delete
    fun delete(repository: RoomGitHubRepository)

    @Delete
    fun delete(vararg repositories: RoomGitHubRepository)

    @Delete
    fun delete(repositories: List<RoomGitHubRepository>)

    @Query("SELECT * FROM GitHubRepositoryTable")
    fun getAll(): Single<List<RoomGitHubRepository>>

    @Query("SELECT * FROM GitHubRepositoryTable WHERE userId = :userId")
    fun findForUser(userId: String): Single<List<RoomGitHubRepository>>

}