package com.cesarwillymc.agrostest.presentation.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.cesarwillymc.agrostest.R
import com.cesarwillymc.agrostest.app.MyApp
import com.cesarwillymc.agrostest.common.hideKeyboard
import com.cesarwillymc.agrostest.common.toast
import com.cesarwillymc.agrostest.databinding.ActivityAuthBinding
import com.cesarwillymc.agrostest.presentation.auth.di.DaggerLoginComponent
import com.cesarwillymc.agrostest.presentation.auth.di.LoginModule
import com.cesarwillymc.agrostest.presentation.main.MainActivity
import javax.inject.Inject

class AuthActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModel: AuthViewModel
    private lateinit var binding:ActivityAuthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onInitDependencyInjection()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_auth)
        binding.lifecycleOwner= this
        onInitDataBinding()

        binding.lblInicioSend.buttonSend.setOnClickListener {
            viewModel.sendMessageLogged()
            signInNumberPhone()
        }
    }

    private fun onInitDependencyInjection() {
        DaggerLoginComponent.builder().coreComponent(MyApp.coreComponent(this))
            .loginModule(LoginModule(this)).build().inject(this)
    }

    private fun onInitDataBinding() {
        binding.viewModel = viewModel
    }

    private fun signInNumberPhone() {
        if (viewModel.stateLogin.value == null) {
            viewModel.stateLogin.observe(this) {
                when (it) {
                    AuthViewState.Loading -> {
                        hideKeyboard()
                    }
                    AuthViewState.Complete -> {
                        try {
                            startActivity(Intent(this, MainActivity::class.java))
                            finish()
                        } catch (e: Exception) {
                            Log.e("errornavi", "$e")
                        }

                    }
                    AuthViewState.Error -> {
                        toast(viewModel.messageError)
                    }
                    else -> {
                    }
                }
            }
        }


    }
}