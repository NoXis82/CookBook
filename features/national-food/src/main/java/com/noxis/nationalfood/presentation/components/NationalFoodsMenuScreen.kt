package com.noxis.nationalfood.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.noxis.domain.enum.NationalFoodsType
import com.noxis.nationalfood.domain.model.NationalFoodsTypeModel
import com.noxis.nationalfood.presentation.event.NationalFoodsUiEvent
import com.noxis.nationalfood.presentation.state.NationalFoodsUiState
import com.noxis.nationalfood.presentation.viewmodel.NationalFoodsViewModel
import com.noxis.presentation.util.asUiPainter
import com.noxis.presentation.util.asUiText

@Composable
fun NationalFoodsMenuScreen(modifier: Modifier = Modifier) {
    val viewModel: NationalFoodsViewModel = hiltViewModel()
    val stateUi by viewModel.uiState.collectAsState()
    LaunchedEffect(key1 = true) {
        viewModel.onUIEvent(NationalFoodsUiEvent.GetAllNationalFoodsType)
    }

    NationalFoodsMenuContent(stateUi = stateUi, modifier = modifier)

}

@Composable
fun NationalFoodsMenuContent(
    modifier: Modifier = Modifier,
    stateUi: NationalFoodsUiState
) {

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(stateUi.type) { item ->
                ItemCard(item = item)
            }

        }
    }
}

@Composable
fun ItemCard(item: NationalFoodsTypeModel) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val nationalFoodsType = NationalFoodsType.valueOf(item.name)
        Card(modifier = Modifier.size(150.dp, 150.dp)) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = nationalFoodsType.asUiPainter().asPainter(),
                contentDescription = null // TODO: Add content description
            )
        }
        Spacer(modifier = Modifier.size(4.dp))
        Text(
            text = nationalFoodsType.asUiText().asString(),
            textAlign = TextAlign.Center,
        )
        Text(text = item.countRecipe.toString())
    }
}


@Composable
@Preview(showBackground = true)
fun NationalFoodsMenuPreview() {
    NationalFoodsMenuContent(stateUi = NationalFoodsUiState(
        type = List(10) {
            NationalFoodsTypeModel(name = "RUSSIAN_AND_SOVIET_FOOD")
        }
    )
    )
}
