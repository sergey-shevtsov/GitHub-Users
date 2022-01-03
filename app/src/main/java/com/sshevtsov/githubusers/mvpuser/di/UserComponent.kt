package com.sshevtsov.githubusers.mvpuser.di

import com.sshevtsov.githubusers.mvpuser.UserPresenter
import dagger.Subcomponent
import javax.inject.Scope

@UserScope
@Subcomponent(
    modules = [
        UserMappersModule::class,
        UserRepositoryModule::class
    ]
)
interface UserComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): UserComponent
    }

    fun inject(userPresenter: UserPresenter)

}

@Scope
annotation class UserScope