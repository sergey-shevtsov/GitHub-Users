package com.sshevtsov.githubusers.mvpusers

import com.github.terrakok.cicerone.Router
import com.sshevtsov.githubusers.ViewState
import com.sshevtsov.githubusers.data.remote.GitHubUserRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.MvpPresenter

class UsersPresenter(
    private val userRepository: GitHubUserRepository,
    private val router: Router
) : MvpPresenter<UsersView>() {

    override fun onFirstViewAttach() {
        onRefresh()
    }

    fun onRefresh() {
        viewState.setState(ViewState.LOADING)
        updateContent()
    }

    private fun updateContent() {
        userRepository.getUsers()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.showUsers(it)
                viewState.setState(ViewState.IDLE)
            }, {
                //todo
            })
    }
}