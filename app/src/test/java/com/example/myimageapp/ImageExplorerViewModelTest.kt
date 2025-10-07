package com.example.myimageapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.myimageapp.ui.ImageExplorerViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ImageExplorerViewModelTest {
    
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    
    private val testDispatcher: TestDispatcher = UnconfinedTestDispatcher()
    private lateinit var viewModel: ImageExplorerViewModel
    private lateinit var fakeRepository: FakeImageRepository
    
    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        fakeRepository = FakeImageRepository()
        viewModel = ImageExplorerViewModel(fakeRepository)
    }
    
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
    
    @Test
    fun testInitialUiState() = runTest {
        val uiState = viewModel.uiState.value
        
        // Should start with the first item
        assertEquals(R.string.title_mountains, uiState.currentTitleRes)
        assertEquals(R.drawable.miu_campus, uiState.currentImageRes)
        assertEquals(false, uiState.isLoading)
    }
    
    @Test
    fun testGetNextUpdatesState() = runTest {
        // Initially at first item
        val initialState = viewModel.uiState.value
        assertEquals(R.string.title_mountains, initialState.currentTitleRes)
        assertEquals(R.drawable.miu_campus, initialState.currentImageRes)
        
        // After calling getNext(), should move to second item
        viewModel.getNext()
        
        val updatedState = viewModel.uiState.value
        assertEquals(R.string.title_ocean, updatedState.currentTitleRes)
        assertEquals(R.drawable.miu_snow_fall, updatedState.currentImageRes)
    }
    
    @Test
    fun testWrapAroundAfterLastItem() = runTest {
        // Navigate to the last item (index 3)
        repeat(3) {
            viewModel.getNext()
        }
        
        val lastItemState = viewModel.uiState.value
        assertEquals(R.string.title_desert, lastItemState.currentTitleRes)
        assertEquals(R.drawable.rainbow, lastItemState.currentImageRes)
        
        // One more getNext() should wrap around to first item
        viewModel.getNext()
        
        val wrappedState = viewModel.uiState.value
        assertEquals(R.string.title_mountains, wrappedState.currentTitleRes)
        assertEquals(R.drawable.miu_campus, wrappedState.currentImageRes)
    }
}