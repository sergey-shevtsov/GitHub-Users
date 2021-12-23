package com.sshevtsov.githubusers.mvpuser

import com.sshevtsov.githubusers.ViewState
import com.sshevtsov.githubusers.data.entities.GitHubRepositoryEntity
import com.sshevtsov.githubusers.data.entities.GitHubUserEntity
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState
import moxy.viewstate.strategy.alias.Skip

interface UserView : MvpView {

    @Skip
    fun setMainState(viewState: ViewState)

    @Skip
    fun setRepoListState(viewState: ViewState)

    @SingleState
    fun showUserContent(userEntity: GitHubUserEntity)

    @SingleState
    fun showRepositories(repositories: List<GitHubRepositoryEntity>)
}