package com.example.myimageapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.myimageapp.ui.ImageExplorerScreen
import com.example.myimageapp.ui.theme.MyImageAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyImageAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ImageExplorerScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}