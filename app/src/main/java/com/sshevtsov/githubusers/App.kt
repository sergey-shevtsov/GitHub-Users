package com.sshevtsov.githubusers

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import com.sshevtsov.githubusers.di.ApplicationComponent
import com.sshevtsov.githubusers.di.DaggerApplicationComponent
import com.sshevtsov.githubusers.mvpuser.di.UserComponent

class App : Application() {

    lateinit var component: ApplicationComponent

    private var userComponent: UserComponent? = null

    override fun onCreate() {
        super.onCreate()

        component = DaggerApplicationComponent.builder()
            .setContext(this)
            .build()
    }

    fun initUserComponent() = component.userComponent().build().apply {
        userComponent = this
    }

    fun destroyUserComponent() {
        userComponent = null
    }

}

val Context.app: App
    get() = applicationContext as App

val Fragment.app: App
    get() = requireContext().app