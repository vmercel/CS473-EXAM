package com.example.myimageapp.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ImageExplorerUiState(
    @StringRes val currentTitleRes: Int = 0,
    @DrawableRes val currentImageRes: Int = 0,
    val isLoading: Boolean = false
)