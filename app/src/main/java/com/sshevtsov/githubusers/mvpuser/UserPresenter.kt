package com.sshevtsov.githubusers.mvpuser

import com.sshevtsov.githubusers.ViewState
import com.sshevtsov.githubusers.data.repository.GitHubUserRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.MvpPresenter
import javax.inject.Inject

class UserPresenter(private val userLogin: String) : MvpPresenter<UserView>() {

    @Inject
    lateinit var userRepository: GitHubUserRepository

    override fun onFirstViewAttach() {
        updateUserContent(userLogin)
        updateRepositoriesContent(userLogin)
    }

    private fun updateUserContent(userLogin: String) {
        viewState.setMainState(ViewState.LOADING)

        userRepository.getUserByLogin(userLogin)
            .observeOn(AndroidSchedulers.mainThread())
            .doFinally { viewState.setMainState(ViewState.IDLE) }
            .subscribe({
                viewState.showUserContent(it)
            }, {
                //todo
            })
    }

    private fun updateRepositoriesContent(userLogin: String) {
        viewState.setRepoListState(ViewState.LOADING)

        userRepository.getUserRepositories(userLogin)
            .observeOn(AndroidSchedulers.mainThread())
            .doFinally { viewState.setRepoListState(ViewState.IDLE) }
            .subscribe({
                viewState.showRepositories(it)
            }, {
                //todo
            })
    }
}