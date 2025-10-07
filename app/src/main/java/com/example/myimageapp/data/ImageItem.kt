package com.example.myimageapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ImageItem(
    @StringRes val titleRes: Int,
    @DrawableRes val imageRes: Int
)