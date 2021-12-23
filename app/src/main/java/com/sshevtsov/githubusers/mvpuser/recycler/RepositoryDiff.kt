package com.sshevtsov.githubusers.mvpuser.recycler

import androidx.recyclerview.widget.DiffUtil
import com.sshevtsov.githubusers.data.entities.GitHubRepositoryEntity

class RepositoryDiff : DiffUtil.ItemCallback<GitHubRepositoryEntity>() {
    override fun areItemsTheSame(oldItem: GitHubRepositoryEntity, newItem: GitHubRepositoryEntity): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: GitHubRepositoryEntity, newItem: GitHubRepositoryEntity): Boolean =
        oldItem == newItem
}