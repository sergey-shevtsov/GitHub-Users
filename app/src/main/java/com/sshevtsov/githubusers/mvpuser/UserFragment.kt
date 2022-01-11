package com.sshevtsov.githubusers.mvpuser

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.sshevtsov.githubusers.BackButtonListener
import com.sshevtsov.githubusers.R
import com.sshevtsov.githubusers.ViewState
import com.sshevtsov.githubusers.app
import com.sshevtsov.githubusers.data.entities.GitHubRepositoryEntity
import com.sshevtsov.githubusers.data.entities.GitHubUserEntity
import com.sshevtsov.githubusers.databinding.FragmentUserBinding
import com.sshevtsov.githubusers.mvpuser.recycler.RepositoriesAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment : MvpAppCompatFragment(R.layout.fragment_user), UserView, BackButtonListener {

    private var _binding: FragmentUserBinding? = null
    private val binding get() = _binding!!

    private val repositoriesAdapter = RepositoriesAdapter()

    private val userLogin by lazy {
        arguments?.getString(ARG_LOGIN).orEmpty()
    }

    private val userComponent by lazy {
        app.initUserComponent()
    }

    private val presenter by moxyPresenter {
        UserPresenter(userLogin).apply {
            userComponent.inject(this)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentUserBinding.bind(view)

        binding.repositoriesRecycler.adapter = repositoriesAdapter

        binding.mainErrorButtonTryAgain.setOnClickListener {
            presenter.load()
        }

        binding.errorRepoListTryAgainButton.setOnClickListener {
            presenter.loadRepositories()
        }
    }

    override fun setMainState(viewState: ViewState) {
        binding.mainProgressIndicatorFrameLayout.isVisible = false
        binding.mainErrorFrameLayout.isVisible = false

        when (viewState) {
            ViewState.LOADING -> binding.mainProgressIndicatorFrameLayout.isVisible = true
            ViewState.ERROR -> binding.mainErrorFrameLayout.isVisible = true
            ViewState.IDLE -> { /* do nothing */ }
        }
    }

    override fun setRepoListState(viewState: ViewState) {
        binding.repositoriesProgressIndicator.isVisible = false
        binding.errorRepoListFrameLayout.isVisible = false
        binding.repositoriesRecycler.isVisible = false
        when (viewState) {
            ViewState.LOADING -> binding.repositoriesProgressIndicator.isVisible = true
            ViewState.ERROR -> binding.errorRepoListFrameLayout.isVisible = true
            ViewState.IDLE -> binding.repositoriesRecycler.isVisible = true
        }
    }

    override fun showUserContent(userEntity: GitHubUserEntity) {
        binding.loginTextView.text = userEntity.login
        binding.avatarProgressIndicator.isVisible = true

        Glide.with(requireContext())
            .load(userEntity.avatarUrl)
            .error(R.drawable.ic_image_error)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    binding.avatarProgressIndicator.isVisible = false
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    binding.avatarProgressIndicator.isVisible = false
                    return false
                }
            })
            .into(binding.avatarImageView)
    }

    override fun showRepositories(repositories: List<GitHubRepositoryEntity>) {
        repositoriesAdapter.submitList(repositories)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
        app.destroyUserComponent()
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

    override fun backPressed(): Boolean = presenter.backPressed()

}