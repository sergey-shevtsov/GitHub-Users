package com.sshevtsov.githubusers.data.room

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

object Migrations {

    val MIGRATION_1_2 = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE GitHubUserTable RENAME TO GitHubUserTableTemp")
            database.execSQL(
                "CREATE TABLE GitHubUserTable (" +
                        "id TEXT PRIMARY KEY NOT NULL," +
                        "login TEXT NOT NULL," +
                        "avatarUrl TEXT NOT NULL," +
                        "htmlUrl TEXT NOT NULL," +
                        "reposUrl TEXT NOT NULL)"
            )
            database.execSQL(
                "INSERT INTO GitHubUserTable " +
                        "SELECT id,login,avatarUrl,htmlUrl,reposUrl " +
                        "FROM GitHubUserTableTemp"
            )
            database.execSQL("DROP TABLE GitHubUserTableTemp")
            database.execSQL(
                "CREATE TABLE GitHubRepositoryTable (" +
                        "id TEXT PRIMARY KEY NOT NULL," +
                        "name TEXT NOT NULL,htmlUrl TEXT NOT NULL," +
                        "language TEXT NOT NULL," +
                        "forksCount TEXT NOT NULL," +
                        "stargazersCount TEXT NOT NULL," +
                        "userId TEXT NOT NULL," +
                        "FOREIGN KEY (userId) REFERENCES GitHubUserTable(id) ON DELETE CASCADE)"
            )
        }
    }

}