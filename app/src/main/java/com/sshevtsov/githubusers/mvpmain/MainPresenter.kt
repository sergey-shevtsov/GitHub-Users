package com.sshevtsov.githubusers.mvpmain

import com.github.terrakok.cicerone.Router
import com.sshevtsov.githubusers.data.network.NetworkStatus
import com.sshevtsov.githubusers.mvpusers.UsersScreen
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class MainPresenter : MvpPresenter<MainView>() {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var networkStatus: NetworkStatus

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        registerNetworkCallback()
        router.replaceScreen(UsersScreen)
    }

    private fun registerNetworkCallback() {
        networkStatus.get()
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { isOnline ->
                if (isOnline) {
                    viewState.hideInternetLostMessage()
                    viewState.showInternetRestoredMessage()

                    Completable.timer(2000L, TimeUnit.MILLISECONDS)
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe { viewState.hideInternetRestoredMessage() }

                } else {
                    viewState.hideInternetRestoredMessage()
                    viewState.showInternetLostMessage()
                }
            }
    }

    fun backClicked() {
        router.exit()
    }

}