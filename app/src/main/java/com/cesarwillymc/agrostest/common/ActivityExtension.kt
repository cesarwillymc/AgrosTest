package com.cesarwillymc.agrostest.common

import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
fun <VM : ViewModel> AppCompatActivity.viewModel(
    key: String? = null,
    factory: () -> VM
): VM {
    val factoryViewModel = factory()
    val viewModelProviderFactory = object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return factoryViewModel as T
        }
    }

    return if (key != null) {

        ViewModelProvider(this, viewModelProviderFactory).get(key, factoryViewModel::class.java)
    } else {
        ViewModelProvider(this, viewModelProviderFactory).get(factoryViewModel::class.java)
    }
}

fun AppCompatActivity.hideKeyboard(){
    try{
        val view = currentFocus
        view!!.clearFocus()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }catch (e :Exception){

    }
}
fun AppCompatActivity.toast(message:String){
    Toast.makeText(this,message, Toast.LENGTH_LONG).show()
}