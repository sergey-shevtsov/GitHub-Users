package com.sshevtsov.githubusers.mvpusers

import com.sshevtsov.githubusers.data.entities.GitHubUserEntity
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

interface UsersView : MvpView {

    @SingleState
    fun showUsers(users: List<GitHubUserEntity>)
}