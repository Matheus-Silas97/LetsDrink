package com.example.letsdrink.presentation.ingredients_details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.letsdrink.common.commons_custom.ImageUrl
import com.example.letsdrink.common.commons_custom.ScaffoldCustom
import com.example.letsdrink.common.commons_custom.TextSubTitle
import com.example.letsdrink.common.commons_custom.TextTitle
import com.example.letsdrink.common.components.DrinkCard
import com.example.letsdrink.common.theme.Typography
import com.example.letsdrink.domain.model.Ingredients
import org.koin.androidx.compose.getViewModel

@Composable
fun IngredientsDetailsScreen(
    ingredientId: Long,
    backStack: () -> Unit,
    goToDetailsDrinkScreen: (id: Long) -> Unit,
    viewModel: IngredientsDetailsViewModel = getViewModel()
) {
    val state by viewModel.state.collectAsState()

    val lazyState = rememberLazyListState()
    val ingredientInfo = Ingredients()

    ScaffoldCustom(
        titlePage = ingredientInfo.name,
        onBackPressedEvent = { backStack() },
        showNavigationIcon = true
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            ImageUrl(
                url = "", modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            )

            TextTitle(text = ingredientInfo.name)

            TextSubTitle(text = "Descrição")
            Text(text = ingredientInfo.description, style = Typography.bodyMedium)

            TextSubTitle(text = "Drinks que utilizam esses ingredientes")
            LazyColumn(state = lazyState, modifier = Modifier.padding(all = 8.dp)) {
                items(items = ingredientInfo.relatedDrinks) { drink ->
                    DrinkCard(model = drink) {
                        goToDetailsDrinkScreen(drink.id ?: 0L)
                    }
                }
            }

        }
    }
}