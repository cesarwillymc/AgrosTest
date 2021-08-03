package com.cesarwillymc.agrostest.common

import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.cesarwillymc.agrostest.R



@BindingAdapter("app:visibilityText")
fun setVisibilty(view: View, isVisible: Boolean) {
    if (isVisible) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}
@BindingAdapter("app:errorText")
fun setError(tInputLayout: EditText, str: String?) {
    if (str.isNullOrEmpty()) {
        tInputLayout.error = null
    } else {
        tInputLayout.error = str

    }
}
@BindingAdapter("app:enabledView")
fun CardView.setEnabledView(enabled: Boolean) {
    this.isEnabled=enabled
    if(enabled){
        setCardBackgroundColor(context.getColor(R.color.enabled))
    }else{
        setCardBackgroundColor(context.getColor(R.color.disable))
    }
}


@BindingAdapter("imageUrl", requireAll = false)
fun ImageView.imageUrl(url: String?) {
    Glide.with(this).load(url).placeholder(R.drawable.loading).error(R.drawable.nofound).into(this)
}



