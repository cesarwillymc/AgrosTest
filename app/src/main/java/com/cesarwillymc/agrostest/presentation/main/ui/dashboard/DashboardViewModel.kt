package com.cesarwillymc.agrostest.presentation.main.ui.dashboard


import androidx.lifecycle.ViewModel
import com.cesarwillymc.agrostest.data.repo.ImageRepo

class DashboardViewModel (imageRepo: ImageRepo): ViewModel() {

    //RV
    val listImage= imageRepo.getImageDB()
}