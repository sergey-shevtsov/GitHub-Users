package com.sshevtsov.githubusers.mvpusers.recycler

import androidx.recyclerview.widget.DiffUtil
import com.sshevtsov.githubusers.data.entities.GitHubUserEntity

class UserDiff : DiffUtil.ItemCallback<GitHubUserEntity>() {

    override fun areItemsTheSame(oldItem: GitHubUserEntity, newItem: GitHubUserEntity): Boolean =
        oldItem.login == newItem.login

    override fun areContentsTheSame(oldItem: GitHubUserEntity, newItem: GitHubUserEntity): Boolean =
        oldItem == newItem
}