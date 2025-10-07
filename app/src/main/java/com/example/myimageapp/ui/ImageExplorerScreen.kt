package com.example.myimageapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
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
                    .weight(1f),
                contentScale = ContentScale.Crop
            )
        }
        
        if (uiState.currentTitleRes != 0) {
            Text(
                text = stringResource(id = uiState.currentTitleRes),
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            )
        }
        
        Button(
            onClick = onNextClick,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = stringResource(id = R.string.button_next))
        }
    }
}

@Preview(showBackground = true, name = "MIU Campus")
@Composable
fun ImageExplorerContentPreview() {
    MyImageAppTheme {
        ImageExplorerContent(
            uiState = ImageExplorerUiState(
                currentTitleRes = R.string.title_mountains,
                currentImageRes = R.drawable.miu_campus
            ),
            onNextClick = {}
        )
    }
}

@Preview(showBackground = true, name = "Snow Fall")
@Composable
fun ImageExplorerOceanPreview() {
    MyImageAppTheme {
        ImageExplorerContent(
            uiState = ImageExplorerUiState(
                currentTitleRes = R.string.title_ocean,
                currentImageRes = R.drawable.miu_snow_fall
            ),
            onNextClick = {}
        )
    }
}

@Preview(showBackground = true, name = "Sustainable Center")
@Composable
fun ImageExplorerForestPreview() {
    MyImageAppTheme {
        ImageExplorerContent(
            uiState = ImageExplorerUiState(
                currentTitleRes = R.string.title_forest,
                currentImageRes = R.drawable.sustainable_living_center
            ),
            onNextClick = {}
        )
    }
}