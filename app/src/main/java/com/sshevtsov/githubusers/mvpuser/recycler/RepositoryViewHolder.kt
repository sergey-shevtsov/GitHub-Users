package com.sshevtsov.githubusers.mvpuser.recycler

import android.content.Intent
import android.net.Uri
import androidx.recyclerview.widget.RecyclerView
import com.sshevtsov.githubusers.R
import com.sshevtsov.githubusers.data.entities.GitHubRepoEntity
import com.sshevtsov.githubusers.databinding.RepositoryListItemBinding

class RepositoryViewHolder(private val binding: RepositoryListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(repositoryEntity: GitHubRepoEntity) {

        binding.apply {

            repositoryNameTextView.text = repositoryEntity.name

            if (repositoryEntity.language?.isNotEmpty() == true && repositoryEntity.language != "null") {
                languageTextView.text = String.format(
                    binding.root.context.getString(R.string.repository_stats_pattern),
                    binding.root.context.getString(R.string.language_stats_title),
                    repositoryEntity.language
                )
            } else {
                languageTextView.text = ""
            }

            forksTextView.text = String.format(
                binding.root.context.getString(R.string.repository_stats_pattern),
                binding.root.context.getString(R.string.forks_stats_title),
                repositoryEntity.forksCount
            )

            starsTextView.text = String.format(
                binding.root.context.getString(R.string.repository_stats_pattern),
                binding.root.context.getString(R.string.stars_stats_title),
                repositoryEntity.stargazersCount
            )

            openInBrowserImageButton.setOnClickListener {
                binding.root.context.startActivity(
                    Intent(Intent.ACTION_VIEW).apply {
                        data = Uri.parse(repositoryEntity.htmlUrl)
                    }
                )
            }
        }

    }
}