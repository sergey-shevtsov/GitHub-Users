package com.sshevtsov.githubusers.mvpuser.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.sshevtsov.githubusers.data.entities.GitHubRepoEntity
import com.sshevtsov.githubusers.databinding.RepositoryListItemBinding

class RepositoriesAdapter : ListAdapter<GitHubRepoEntity, RepositoryViewHolder>(RepositoryDiff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder =
        RepositoryViewHolder(
            RepositoryListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}