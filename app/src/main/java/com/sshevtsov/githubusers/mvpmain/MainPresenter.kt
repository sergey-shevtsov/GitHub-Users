package com.sshevtsov.githubusers.mvpmain

import com.github.terrakok.cicerone.Router
import com.sshevtsov.githubusers.data.network.NetworkStatus
import com.sshevtsov.githubusers.mvpusers.UsersScreen
import moxy.MvpPresenter
import javax.inject.Inject

class MainPresenter : MvpPresenter<MainView>() {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var networkStatus: NetworkStatus

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(UsersScreen)
    }

    fun backClicked() {
        router.exit()
    }

}