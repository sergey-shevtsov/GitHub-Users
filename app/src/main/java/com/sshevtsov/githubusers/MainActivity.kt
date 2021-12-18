package com.sshevtsov.githubusers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sshevtsov.githubusers.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}