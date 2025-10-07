package com.example.myimageapp.repository

import com.example.myimageapp.data.ImageItem

interface ImageRepository {
    fun getAll(): List<ImageItem>
    fun getItemAtIndex(index: Int): ImageItem
    fun getNextIndex(currentIndex: Int): Int
}