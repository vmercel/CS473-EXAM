package com.example.myimageapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myimageapp.R
import com.example.myimageapp.ui.theme.MyImageAppTheme

@Composable
fun ImageExplorerScreen(
    modifier: Modifier = Modifier,
    viewModel: ImageExplorerViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    
    ImageExplorerContent(
        uiState = uiState,
        onNextClick = viewModel::getNext,
        modifier = modifier
    )
}

@Composable
fun ImageExplorerContent(
    uiState: ImageExplorerUiState,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        if (uiState.currentImageRes != 0) {
            Image(
                painter = painterResource(id = uiState.currentImageRes),
                contentDescription = if (uiState.currentTitleRes != 0) {
                    stringResource(id = uiState.currentTitleRes)
                } else {
                    null
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f),
                contentScale = ContentScale.Crop
            )
        }

        if (uiState.currentTitleRes != 0) {
            Text(
                text = stringResource(id = uiState.currentTitleRes),
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp, horizontal = 16.dp)
            )
        }

        Button(
            onClick = onNextClick,
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .padding(top = 8.dp)
        ) {
            Text(
                text = stringResource(id = R.string.button_next),
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}

@Preview(showBackground = true, name = "Interactive Image Explorer")
@Composable
fun ImageExplorerInteractivePreview() {
    MyImageAppTheme {
        // This preview shows the actual interactive screen
        // Click "Next" to cycle through images with wrap-around
        ImageExplorerScreen()
    }
}

@Preview(showBackground = true, name = "Static - First Image")
@Composable
fun ImageExplorerStaticPreview() {
    MyImageAppTheme {
        ImageExplorerContent(
            uiState = ImageExplorerUiState(
                currentTitleRes = R.string.title_compro_professionals,
                currentImageRes = R.drawable.compro_professionals
            ),
            onNextClick = {} // Static preview - no interaction
        )
    }
}