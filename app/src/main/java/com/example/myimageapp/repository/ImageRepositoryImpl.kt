package com.example.myimageapp.repository

import com.example.myimageapp.data.ImageDataSource
import com.example.myimageapp.data.ImageItem
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImageRepositoryImpl @Inject constructor() : ImageRepository {
    
    private val images = ImageDataSource.images
    
    override fun getAll(): List<ImageItem> {
        return images
    }
    
    override fun getItemAtIndex(index: Int): ImageItem {
        return images[index]
    }
    
    override fun getNextIndex(currentIndex: Int): Int {
        return (currentIndex + 1) % images.size
    }
}