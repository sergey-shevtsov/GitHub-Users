package com.sshevtsov.githubusers.mvpuser.recycler

import androidx.recyclerview.widget.DiffUtil
import com.sshevtsov.githubusers.data.entities.GitHubRepoEntity

class RepositoryDiff : DiffUtil.ItemCallback<GitHubRepoEntity>() {
    override fun areItemsTheSame(oldItem: GitHubRepoEntity, newItem: GitHubRepoEntity): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: GitHubRepoEntity, newItem: GitHubRepoEntity): Boolean =
        oldItem == newItem
}