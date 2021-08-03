package com.cesarwillymc.agrostest.presentation.main.ui.home



sealed class HomeViewModelState {

    /** Edit Text State URL **/
    object URLEmpty : HomeViewModelState()
    object URLError : HomeViewModelState()
    object URLSucces : HomeViewModelState()

    fun isURLEmpty() = this is URLEmpty
    fun isURLError() = this is URLError
    fun isURLSucces() = this is URLSucces
}