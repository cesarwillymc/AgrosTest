package com.cesarwillymc.agrostest.presentation.main.ui.dashboard.common

fun isLastItemandInpair(size:Int,position:Int):Boolean{
    return (size%2!=0) && (size-1==position)
}