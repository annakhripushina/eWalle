package com.example.ewalle.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.ewalle.App
import com.example.ewalle.R
import com.example.ewalle.databinding.LoginFragmentBinding
import com.example.ewalle.presentation.login.LoginViewModel
import com.example.ewalle.ui.mainScreen.MainScreenFragment
import javax.inject.Inject


class LoginFragment : Fragment() {
    @Inject
    lateinit var viewModel: LoginViewModel

    private lateinit var binding: LoginFragmentBinding
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toolbar: Toolbar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (requireActivity().applicationContext as App).appComponent.inject(this)
        binding = LoginFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        closeToolbar()
        setView()
        setButtonsListeners()
    }

    private fun closeToolbar() {
        drawerLayout = activity?.findViewById<View>(R.id.drawer_layout) as DrawerLayout
        toolbar = activity?.findViewById<View>(R.id.toolbar) as Toolbar
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        toolbar.visibility = INVISIBLE
    }

    private fun setView() {
        binding.time.text = viewModel.getTime()
        binding.date.text = viewModel.getDate()
        binding.temperature.text = viewModel.getTemperature()
    }

    private fun setButtonsListeners() {
        binding.joinForFree.setOnClickListener {
            if (viewModel.joinForFree())
                openMainScreen()
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
            toolbar.visibility = VISIBLE
        }

        binding.buttonSignIn.setOnClickListener {
            if (viewModel.signInUser())
                openMainScreen()
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
            toolbar.visibility = VISIBLE
        }

        binding.createAccount.setOnClickListener {
            if (viewModel.createUser())
                openMainScreen()
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
            toolbar.visibility = VISIBLE
        }
    }

    private fun openMainScreen() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.mainFragmentContainer, MainScreenFragment())
            .commit()
    }
}