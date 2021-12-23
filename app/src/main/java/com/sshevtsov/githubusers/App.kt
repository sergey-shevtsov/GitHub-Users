package com.sshevtsov.githubusers

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.github.terrakok.cicerone.Cicerone
import com.sshevtsov.githubusers.data.room.DBStorage

class App : Application() {

    private val cicerone = Cicerone.create()
    val router get() = cicerone.router
    val navigatorHolder get() = cicerone.getNavigatorHolder()

    override fun onCreate() {
        super.onCreate()

        database =
            Room.databaseBuilder(this, DBStorage::class.java, "github.db").build()
    }

    companion object {
        lateinit var database: DBStorage
    }

}

val Context.app: App
    get() = applicationContext as App

val Fragment.app: App
    get() = requireContext().app