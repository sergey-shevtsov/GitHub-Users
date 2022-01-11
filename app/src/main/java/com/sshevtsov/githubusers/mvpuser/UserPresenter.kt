package com.sshevtsov.githubusers.mvpuser

import com.github.terrakok.cicerone.Router
import com.sshevtsov.githubusers.ViewState
import com.sshevtsov.githubusers.data.repository.GitHubRepoRepository
import com.sshevtsov.githubusers.data.repository.GitHubUserRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.MvpPresenter
import javax.inject.Inject
import kotlin.random.Random

class UserPresenter(private val userLogin: String) : MvpPresenter<UserView>() {

    @Inject
    lateinit var userRepository: GitHubUserRepository

    @Inject
    lateinit var repoRepository: GitHubRepoRepository

    @Inject
    lateinit var router: Router

    override fun onFirstViewAttach() {
        load()
    }

    fun load() {
        updateUserContent()
        loadRepositories()
    }

    fun loadRepositories() {
        updateRepositoriesContent()
    }

    private fun updateUserContent() {
        viewState.setMainState(ViewState.LOADING)

        userRepository.getUserByLogin(userLogin)
            .observeOn(AndroidSchedulers.mainThread())
            .doFinally { viewState.setMainState(ViewState.IDLE) }
            .subscribe({
                viewState.showUserContent(it)
            }, {
                viewState.setMainState(ViewState.ERROR)
            })
    }

    private fun updateRepositoriesContent() {
        viewState.setRepoListState(ViewState.LOADING)

        repoRepository.getUserRepositories(userLogin)
            .observeOn(AndroidSchedulers.mainThread())
            .doFinally { viewState.setRepoListState(ViewState.IDLE) }
            .subscribe({
                viewState.showRepositories(it)
            }, {
                viewState.setRepoListState(ViewState.ERROR)
            })
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}