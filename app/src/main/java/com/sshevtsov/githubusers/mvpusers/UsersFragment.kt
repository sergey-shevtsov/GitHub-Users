package com.sshevtsov.githubusers.mvpusers

import android.os.Bundle
import android.view.View
import com.sshevtsov.githubusers.R
import com.sshevtsov.githubusers.databinding.FragmentUsersBinding
import moxy.MvpAppCompatFragment

class UsersFragment : MvpAppCompatFragment(R.layout.fragment_users), UsersView {

    private var _binding: FragmentUsersBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentUsersBinding.bind(view)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    companion object {
        fun newInstance(): UsersFragment = UsersFragment()
    }

}