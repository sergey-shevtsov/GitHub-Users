package com.sshevtsov.githubusers.mvpusers

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.sshevtsov.githubusers.BackButtonListener
import com.sshevtsov.githubusers.R
import com.sshevtsov.githubusers.ViewState
import com.sshevtsov.githubusers.app
import com.sshevtsov.githubusers.data.entities.GitHubUserEntity
import com.sshevtsov.githubusers.databinding.FragmentUsersBinding
import com.sshevtsov.githubusers.mvpusers.recycler.UsersAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment :
    MvpAppCompatFragment(R.layout.fragment_users), UsersView, UsersAdapter.OnUserClickListener,
    BackButtonListener {

    private var _binding: FragmentUsersBinding? = null
    private val binding get() = _binding!!

    private val usersAdapter = UsersAdapter(this)

    private val presenter by moxyPresenter {
        UsersPresenter().apply {
            app.component.inject(this)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentUsersBinding.bind(view)

        binding.usersRecyclerView.adapter = usersAdapter

        binding.swipeRefreshLayout.setOnRefreshListener {
            binding.swipeRefreshLayout.isRefreshing = false
            presenter.load()
        }

        binding.buttonTryAgain.setOnClickListener {
            presenter.load()
        }
    }

    override fun setState(viewState: ViewState) {
        binding.progressIndicatorFrameLayout.isVisible = false
        binding.errorFrameLayout.isVisible = false
        when (viewState) {
            ViewState.ERROR -> binding.errorFrameLayout.isVisible = true
            ViewState.LOADING -> binding.progressIndicatorFrameLayout.isVisible = true
            ViewState.IDLE -> { /* do nothing */ }
        }
    }

    override fun showUsers(users: List<GitHubUserEntity>) {
        usersAdapter.submitList(users)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    companion object {
        fun newInstance(): UsersFragment = UsersFragment()
    }

    override fun onUserClicked(userLogin: String) {
        presenter.onUserClicked(userLogin)
    }

    override fun backPressed(): Boolean = presenter.backPressed()

}