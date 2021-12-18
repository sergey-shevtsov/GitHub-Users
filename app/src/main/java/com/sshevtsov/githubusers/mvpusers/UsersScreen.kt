package com.sshevtsov.githubusers.mvpusers

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

object UsersScreen : FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment {
        return UsersFragment.newInstance()
    }

}