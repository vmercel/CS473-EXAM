package com.example.myimageapp

import com.example.myimageapp.data.ImageItem
import com.example.myimageapp.repository.ImageRepository
import com.example.myimageapp.R

class FakeImageRepository : ImageRepository {
    
    private val fakeImages = listOf(
        ImageItem(titleRes = R.string.title_mountains, imageRes = R.drawable.miu_campus),
        ImageItem(titleRes = R.string.title_ocean, imageRes = R.drawable.miu_snow_fall),
        ImageItem(titleRes = R.string.title_forest, imageRes = R.drawable.sustainable_living_center),
        ImageItem(titleRes = R.string.title_desert, imageRes = R.drawable.rainbow)
    )
    
    override fun getAll(): List<ImageItem> {
        return fakeImages
    }
    
    override fun getItemAtIndex(index: Int): ImageItem {
        return fakeImages[index]
    }
    
    override fun getNextIndex(currentIndex: Int): Int {
        return (currentIndex + 1) % fakeImages.size
    }
}