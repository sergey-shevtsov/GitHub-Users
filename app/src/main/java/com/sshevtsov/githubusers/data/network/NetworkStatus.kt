package com.sshevtsov.githubusers.data.network

import io.reactivex.rxjava3.core.Observable

interface NetworkStatus {

    fun get(): Observable<Boolean>

}