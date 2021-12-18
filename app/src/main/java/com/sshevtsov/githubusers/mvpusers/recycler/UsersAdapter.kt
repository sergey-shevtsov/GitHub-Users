package com.sshevtsov.githubusers.mvpusers.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.sshevtsov.githubusers.data.entities.GitHubUserEntity
import com.sshevtsov.githubusers.databinding.UserListItemBinding

class UsersAdapter(
    private val onUserClickListener: OnUserClickListener
) : ListAdapter<GitHubUserEntity, UserViewHolder>(UserDiff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder =
        UserViewHolder(
            UserListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) =
        holder.bind(getItem(position), onUserClickListener)


    fun interface OnUserClickListener {
        fun onUserClicked(userLogin: String)
    }
}