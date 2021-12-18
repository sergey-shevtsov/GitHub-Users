package com.sshevtsov.githubusers.mvpusers

import com.sshevtsov.githubusers.ViewState
import com.sshevtsov.githubusers.data.entities.GitHubUserEntity
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState
import moxy.viewstate.strategy.alias.Skip

interface UsersView : MvpView {

    @Skip
    fun setState(viewState: ViewState)

    @SingleState
    fun showUsers(users: List<GitHubUserEntity>)
}