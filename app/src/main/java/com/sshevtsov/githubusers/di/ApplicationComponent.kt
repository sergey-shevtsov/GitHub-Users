package com.sshevtsov.githubusers.di

import android.content.Context
import com.sshevtsov.githubusers.mvpmain.MainActivity
import com.sshevtsov.githubusers.mvpmain.MainPresenter
import com.sshevtsov.githubusers.mvpuser.di.UserComponent
import com.sshevtsov.githubusers.mvpusers.UsersPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        CiceroneModule::class,
        MappersModule::class,
        NetworkModule::class,
        RetrofitModule::class,
        RepositoryModule::class,
        RoomModule::class
    ]
)
interface ApplicationComponent {

    fun userComponent(): UserComponent.Builder

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun setContext(context: Context): Builder

        fun build(): ApplicationComponent
    }

    fun inject(activity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(usersPresenter: UsersPresenter)

}