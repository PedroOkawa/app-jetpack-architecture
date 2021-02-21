package com.okawa.jetpack.arch.ui.composable.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.okawa.jetpack.arch.ui.composable.theme.JetpackArchTheme
import com.okawa.jetpack.arch.ui.composable.theme.componentSmall
import com.okawa.jetpack.arch.ui.composable.theme.componentXXXLarge

@Preview
@Composable
fun PreviewLoadings() {
    Column {
        CircularLoading(text = "Loading...")
        HorizontalLoading(text = "Loading...")
    }
}

@Composable
fun CircularLoading(
    text: String,
    modifier: Modifier = Modifier
) {
    JetpackArchTheme {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator(
                modifier = modifier
                    .size(size = componentXXXLarge)
                    .padding(all = componentSmall)
            )
            Text(
                text = text,
                style = MaterialTheme.typography.caption
            )
        }
    }
}

@Composable
fun HorizontalLoading(
    text: String,
    modifier: Modifier = Modifier
) {
    JetpackArchTheme {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LinearProgressIndicator(
                modifier = modifier
                    .size(size = componentXXXLarge)
                    .padding(all = componentSmall)
            )
            Text(
                text = text,
                style = MaterialTheme.typography.caption
            )
        }
    }
}