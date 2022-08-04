package com.example.ewalle.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ewalle.App
import com.example.ewalle.R
import com.example.ewalle.databinding.LoginFragmentBinding
import com.example.ewalle.presentation.login.LoginViewModel
import javax.inject.Inject

class LoginFragment : Fragment(){

    private lateinit var binding: LoginFragmentBinding

    @Inject
    lateinit var viewModel: LoginViewModel

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

        binding.time.text = viewModel.getTime()
        binding.date.text = viewModel.getDate()
        binding.temperature.text = viewModel.getTemperature()

        binding.joinForFree.setOnClickListener {
            if (viewModel.joinForFree())
                openMainScreen()
        }

        binding.buttonSignIn.setOnClickListener {
            if (viewModel.signInUser())
                openMainScreen()
        }

        binding.createAccount.setOnClickListener {
            if (viewModel.createUser())
                openMainScreen()
        }

    }

    private fun openMainScreen(){
        parentFragmentManager.beginTransaction()
            .replace(R.id.mainFragmentContainer, MainScreenFragment())
            .commit()
    }
}