package com.sshevtsov.githubusers.mvpuser

import com.sshevtsov.githubusers.data.remote.GitHubUserRepository
import moxy.MvpPresenter

class UserPresenter(
    private val userRepository: GitHubUserRepository
) : MvpPresenter<UserView>() {
}