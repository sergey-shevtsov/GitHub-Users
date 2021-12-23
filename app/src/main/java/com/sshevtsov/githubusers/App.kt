package com.sshevtsov.githubusers

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.sshevtsov.githubusers.data.room.DBStorage
import com.sshevtsov.githubusers.data.room.Migrations
import com.sshevtsov.githubusers.di.ApplicationComponent
import com.sshevtsov.githubusers.di.DaggerApplicationComponent

class App : Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerApplicationComponent.builder()
            .setContext(this)
            .build()
    }

}

val Context.app: App
    get() = applicationContext as App

val Fragment.app: App
    get() = requireContext().app