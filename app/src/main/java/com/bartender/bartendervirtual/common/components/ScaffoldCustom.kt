package com.bartender.bartendervirtual.common.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldCustom(
    titlePage: String = "",
    showNavigationIcon: Boolean = false,
    onBackPressedEvent: () -> Unit = {},
    isLoading: Boolean = false,
    messageLoading: String = "",
    contentComponent: @Composable () -> Unit
) {
    val loadingComponentState = remember{ mutableStateOf(false) }

    Scaffold(containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopBar(
                title = titlePage,
                showNavigationIcon = showNavigationIcon,
                onBackPressed = { onBackPressedEvent() })
        }, content = {
            Box(modifier = Modifier.padding(paddingValues = it)) {
                if (!loadingComponentState.value) {
                    LoadingComponent(text = messageLoading, isLoading) { loadingComponentState.value = true }
                } else {
                    contentComponent()
                }
            }
        })
}