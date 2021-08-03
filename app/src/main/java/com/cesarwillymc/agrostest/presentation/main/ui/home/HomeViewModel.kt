package com.cesarwillymc.agrostest.presentation.main.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _stateURL = MutableLiveData<HomeViewModelState>(HomeViewModelState.URLSucces)
    val stateURL: LiveData<HomeViewModelState> get() = _stateURL


    private lateinit var _dataURL: String
    val dataURL get() = _dataURL

    fun updateTextURL(URL: CharSequence) {
        if (URL.isNotEmpty()) {
            if (URL.contains("http")) {
                _stateURL.postValue(HomeViewModelState.URLSucces)
                _dataURL = URL.toString()
            } else {
                _stateURL.postValue(HomeViewModelState.URLError)
            }
        } else {
            _stateURL.postValue(HomeViewModelState.URLEmpty)
        }
    }

    lateinit var onClick: (String) -> Unit
}