package io.github.regbl.migrainetracker.adapters

import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import com.google.android.material.slider.Slider

@InverseBindingAdapter(attribute = "android:value")
fun getSliderValue(slider: Slider) = slider.value

@BindingAdapter("android:valueAttrChanged")
fun setSliderListeners(slider: Slider, attrChanged: InverseBindingListener) {
    slider.addOnChangeListener { _, _, _ -> attrChanged.onChange() }
}