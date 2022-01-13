package com.sshevtsov.githubusers.mvpmain

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.SingleState

interface MainView : MvpView {

    @AddToEndSingle
    fun showInternetLostMessage()

    @SingleState
    fun hideInternetLostMessage()

    @AddToEndSingle
    fun showInternetRestoredMessage()

    @SingleState
    fun hideInternetRestoredMessage()

}