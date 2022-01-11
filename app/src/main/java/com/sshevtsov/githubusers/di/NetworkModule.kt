package com.sshevtsov.githubusers.di

import android.content.Context
import com.sshevtsov.githubusers.data.network.NetworkStatus
import com.sshevtsov.githubusers.data.network.NetworkStatusImpl
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class NetworkModule {

    @Provides
    @Reusable
    fun provideNetworkStatus(context: Context): NetworkStatus {
        return NetworkStatusImpl(context)
    }

}