package com.sshevtsov.githubusers.mvpuser

import android.os.Bundle
import android.view.View
import com.sshevtsov.githubusers.R
import com.sshevtsov.githubusers.data.remote.GitHubUserRepositoryFactory
import com.sshevtsov.githubusers.databinding.FragmentUserBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment : MvpAppCompatFragment(R.layout.fragment_user), UserView {

    private var _binding: FragmentUserBinding? = null
    private val binding get() = _binding!!

    private val presenter by moxyPresenter {
        UserPresenter(GitHubUserRepositoryFactory.create())
    }

    private val userLogin by lazy {
        arguments?.getString(ARG_LOGIN).orEmpty()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentUserBinding.bind(view)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    companion object {
        private const val ARG_LOGIN = "arg_login"

        fun newInstance(userLogin: String): UserFragment =
            UserFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_LOGIN, userLogin)
                }
            }
    }
}