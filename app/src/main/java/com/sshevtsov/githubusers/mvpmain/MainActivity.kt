package com.sshevtsov.githubusers.mvpmain

import android.os.Bundle
import androidx.core.view.isVisible
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.sshevtsov.githubusers.BackButtonListener
import com.sshevtsov.githubusers.R
import com.sshevtsov.githubusers.app
import com.sshevtsov.githubusers.databinding.ActivityMainBinding
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity(), MainView {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val navigator = AppNavigator(this, R.id.fragment_container)

    private val presenter by moxyPresenter {
        MainPresenter().apply {
            app.component.inject(this)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        app.component.inject(this)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if (it is BackButtonListener && it.backPressed()) {
                return
            }
        }
        presenter.backClicked()
    }

    override fun showInternetLostMessage() {
        binding.internetLostTextView.isVisible = true
    }

    override fun hideInternetLostMessage() {
        binding.internetLostTextView.isVisible = false
    }

    override fun showInternetRestoredMessage() {
        binding.internetRestoredTextView.isVisible = true
    }

    override fun hideInternetRestoredMessage() {
        binding.internetRestoredTextView.isVisible = false
    }
}