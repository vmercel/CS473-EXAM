package com.example.myimageapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myimageapp.repository.ImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImageExplorerViewModel @Inject constructor(
    private val imageRepository: ImageRepository
) : ViewModel() {
    
    private var currentIndex = 0
    
    private val _uiState = MutableStateFlow(ImageExplorerUiState())
    val uiState: StateFlow<ImageExplorerUiState> = _uiState.asStateFlow()
    
    init {
        initializeUiState()
    }
    
    private fun initializeUiState() {
        viewModelScope.launch {
            val currentItem = imageRepository.getItemAtIndex(currentIndex)
            _uiState.value = ImageExplorerUiState(
                currentTitleRes = currentItem.titleRes,
                currentImageRes = currentItem.imageRes,
                isLoading = false
            )
        }
    }
    
    fun getNext() {
        viewModelScope.launch {
            currentIndex = imageRepository.getNextIndex(currentIndex)
            val nextItem = imageRepository.getItemAtIndex(currentIndex)
            _uiState.value = _uiState.value.copy(
                currentTitleRes = nextItem.titleRes,
                currentImageRes = nextItem.imageRes
            )
        }
    }
}