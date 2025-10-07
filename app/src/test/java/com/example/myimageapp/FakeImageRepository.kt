package com.example.myimageapp

import com.example.myimageapp.data.ImageItem
import com.example.myimageapp.repository.ImageRepository
import com.example.myimageapp.R

class FakeImageRepository : ImageRepository {
    
    private val fakeImages = listOf(
        ImageItem(titleRes = R.string.title_compro_professionals, imageRes = R.drawable.compro_professionals),
        ImageItem(titleRes = R.string.title_compro_admission, imageRes = R.drawable.compro_admission_team),
        ImageItem(titleRes = R.string.title_faculty_student, imageRes = R.drawable.faculty_student),
        ImageItem(titleRes = R.string.title_friends, imageRes = R.drawable.friends),
        ImageItem(titleRes = R.string.title_graduation, imageRes = R.drawable.graduation)
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