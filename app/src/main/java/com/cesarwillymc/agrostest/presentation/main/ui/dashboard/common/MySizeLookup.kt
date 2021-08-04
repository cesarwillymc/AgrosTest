package com.cesarwillymc.agrostest.presentation.main.ui.dashboard.common

import androidx.recyclerview.widget.GridLayoutManager

class MySizeLookup(private val size:Int): GridLayoutManager.SpanSizeLookup() {
    override fun getSpanSize(position: Int): Int {
        return if (isLastItemandInpair(size,position)) {
            2
        }else {
            1
        }
    }
}