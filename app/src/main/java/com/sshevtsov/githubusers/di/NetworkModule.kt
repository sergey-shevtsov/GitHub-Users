package com.sshevtsov.githubusers.di

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.sshevtsov.githubusers.data.network.NetworkStatus
import com.sshevtsov.githubusers.data.network.NetworkStatusImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {

    @RequiresApi(Build.VERSION_CODES.N)
    @Singleton
    @Provides
    fun provideNetworkStatus(context: Context): NetworkStatus =
        NetworkStatusImpl(context)

}