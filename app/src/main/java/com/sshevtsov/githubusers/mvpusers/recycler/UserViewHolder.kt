package com.sshevtsov.githubusers.mvpusers.recycler

import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.sshevtsov.githubusers.R
import com.sshevtsov.githubusers.data.entities.GitHubUserEntity
import com.sshevtsov.githubusers.databinding.UserListItemBinding

class UserViewHolder(
    private val binding: UserListItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(user: GitHubUserEntity, onUserClickListener: UsersAdapter.OnUserClickListener) {

        binding.loginTextView.text = user.login
        binding.avatarProgressIndicator.isVisible = true

        Glide.with(binding.avatarImageView.context)
            .load(user.avatarUrl)
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

        binding.openInBrowserImageButton.setOnClickListener {
            user.htmlUrl?.let { htmlUrl ->
                binding.root.context.startActivity(
                    Intent(Intent.ACTION_VIEW).apply {
                        data = Uri.parse(htmlUrl)
                    }
                )
            }
        }

        binding.root.setOnClickListener {
            user.login?.let { login ->
                onUserClickListener.onUserClicked(login)
            }
        }
    }
}