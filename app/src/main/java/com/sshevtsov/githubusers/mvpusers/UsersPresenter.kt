package com.sshevtsov.githubusers.mvpusers

import com.github.terrakok.cicerone.Router
import com.sshevtsov.githubusers.ViewState
import com.sshevtsov.githubusers.data.repository.GitHubUserRepository
import com.sshevtsov.githubusers.mvpuser.UserScreen
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.MvpPresenter
import javax.inject.Inject
import kotlin.random.Random

class UsersPresenter : MvpPresenter<UsersView>() {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var userRepository: GitHubUserRepository

    override fun onFirstViewAttach() {
        load()
    }

    fun load() {
        viewState.setState(ViewState.LOADING)
        updateContent()
    }

    private fun updateContent() {
        userRepository.getUsers()
            .observeOn(AndroidSchedulers.mainThread())
            .doFinally { viewState.setState(ViewState.IDLE) }
            .subscribe({
                viewState.showUsers(it)
            }, {
                viewState.setState(ViewState.ERROR)
            })
    }

    fun onUserClicked(userLogin: String) {
        router.navigateTo(UserScreen(userLogin))
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}