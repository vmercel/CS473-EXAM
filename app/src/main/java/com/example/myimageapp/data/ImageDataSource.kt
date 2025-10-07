package com.example.myimageapp.data

import com.example.myimageapp.R

object ImageDataSource {
    val images = listOf(
        ImageItem(
            titleRes = R.string.title_mountains,
            imageRes = R.drawable.miu_campus
        ),
        ImageItem(
            titleRes = R.string.title_ocean,
            imageRes = R.drawable.miu_snow_fall
        ),
        ImageItem(
            titleRes = R.string.title_forest,
            imageRes = R.drawable.sustainable_living_center
        ),
        ImageItem(
            titleRes = R.string.title_desert,
            imageRes = R.drawable.rainbow
        )
    )
}