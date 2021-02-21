package com.okawa.jetpack.arch.search.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.okawa.jetpack.arch.search.R
import com.okawa.jetpack.arch.ui.composable.component.TextInput
import com.okawa.jetpack.arch.ui.composable.theme.JetpackArchTypography
import com.okawa.jetpack.arch.ui.composable.theme.componentLarge
import com.okawa.jetpack.arch.ui.composable.theme.componentSmall

@Preview
@Composable
fun PreviewSearchScreen() {
    SearchScreen(
        title = "Search",
        hint = "Search for a job...",
        messages = mutableStateOf(listOf("One", "Two", "Three")),
        onInputChanged = { }
    )
}

@Composable
fun SearchScreen(
    title: String,
    hint: String,
    messages: MutableState<List<String>>,
    onInputChanged: (String) -> Unit
) {
    val cachedMessages by remember { mutableStateOf(messages) }

    Column {
        Scaffold(
            topBar = { SearchTopBar(title) },
            bodyContent = {
                Column(modifier = Modifier.padding(componentLarge)) {
                    TextInput(
                        hint = hint,
                        onInputChanged = onInputChanged,
                        drawableResEnd = R.drawable.ic_search_24
                    )
                    if (cachedMessages.value.isEmpty()) {

                    } else {
                        LazyColumn {
                            items(cachedMessages.value) { item ->
                                Text(
                                    text = item,
                                    style = MaterialTheme.typography.body1
                                )
                            }
                        }
                    }
                }
            }
        )
    }
}

@Composable
fun SearchTopBar(title: String) {
    TopAppBar(
        elevation = componentSmall,
        backgroundColor = MaterialTheme.colors.primarySurface,
        contentColor = contentColorFor(backgroundColor)
    ) {
        Text(
            text = title,
            style = JetpackArchTypography.h6,
            color = MaterialTheme.colors.onPrimary,
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        )
    }
}