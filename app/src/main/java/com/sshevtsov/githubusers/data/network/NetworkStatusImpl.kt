package com.sshevtsov.githubusers.data.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.os.Build
import androidx.annotation.RequiresApi
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.BehaviorSubject
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.N)
class NetworkStatusImpl @Inject constructor(context: Context) : NetworkStatus {

    private val statusSubject = BehaviorSubject.createDefault(false)

    init {

        val networkCallback = object : ConnectivityManager.NetworkCallback() {

            override fun onAvailable(network: Network) {
                statusSubject.onNext(true)
            }

            override fun onLost(network: Network) {
                statusSubject.onNext(false)
            }
        }

        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        connectivityManager.registerDefaultNetworkCallback(networkCallback)

    }


    override fun get(): Observable<Boolean> = statusSubject

}