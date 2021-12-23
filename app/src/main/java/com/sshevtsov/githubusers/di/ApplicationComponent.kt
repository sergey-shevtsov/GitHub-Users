package com.sshevtsov.githubusers.di

import android.content.Context
import com.sshevtsov.githubusers.MainActivity
import com.sshevtsov.githubusers.mvpuser.UserPresenter
import com.sshevtsov.githubusers.mvpusers.UsersPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        CiceroneModule::class,
        NetworkModule::class,
        RepositoryModule::class,
        RoomModule::class
    ]
)
interface ApplicationComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun setContext(context: Context): Builder

        fun build(): ApplicationComponent
    }

    fun inject(activity: MainActivity)
    fun inject(usersPresenter: UsersPresenter)
    fun inject(userPresenter: UserPresenter)

}