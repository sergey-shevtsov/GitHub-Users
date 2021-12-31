package com.sshevtsov.githubusers.mvpuser

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.sshevtsov.githubusers.R
import com.sshevtsov.githubusers.ViewState
import com.sshevtsov.githubusers.app
import com.sshevtsov.githubusers.data.entities.GitHubRepositoryEntity
import com.sshevtsov.githubusers.data.entities.GitHubUserEntity
import com.sshevtsov.githubusers.databinding.FragmentUserBinding
import com.sshevtsov.githubusers.mvpuser.recycler.RepositoriesAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment : MvpAppCompatFragment(R.layout.fragment_user), UserView {

    private var _binding: FragmentUserBinding? = null
    private val binding get() = _binding!!

    private val repositoriesAdapter = RepositoriesAdapter()

    private val presenter by moxyPresenter {
        UserPresenter(userLogin).apply {
            app.component.userComponent().build().inject(this)
        }
    }

    private val userLogin by lazy {
        arguments?.getString(ARG_LOGIN).orEmpty()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentUserBinding.bind(view)

        binding.repositoriesRecycler.adapter = repositoriesAdapter
    }

    override fun setMainState(viewState: ViewState) {
        when (viewState) {
            ViewState.LOADING -> binding.mainProgressIndicatorFrameLayout.isVisible = true
            ViewState.IDLE -> binding.mainProgressIndicatorFrameLayout.isVisible = false
        }
    }

    override fun setRepoListState(viewState: ViewState) {
        when (viewState) {
            ViewState.LOADING -> binding.repositoriesProgressIndicator.isVisible = true
            ViewState.IDLE -> binding.repositoriesProgressIndicator.isVisible = false
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