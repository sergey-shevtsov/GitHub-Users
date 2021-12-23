package com.sshevtsov.githubusers.mvpusers

import com.github.terrakok.cicerone.Router
import com.sshevtsov.githubusers.ViewState
import com.sshevtsov.githubusers.data.repository.GitHubUserRepository
import com.sshevtsov.githubusers.mvpuser.UserScreen
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.MvpPresenter
import javax.inject.Inject

class UsersPresenter(
    private val userRepository: GitHubUserRepository
) : MvpPresenter<UsersView>() {

    @Inject
    lateinit var router: Router

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
            .doFinally { viewState.setState(ViewState.IDLE) }
            .subscribe({
                viewState.showUsers(it)
            }, {
                //todo
            })
    }

    fun onUserClicked(userLogin: String) {
        router.navigateTo(UserScreen(userLogin))
    }
}