package com.okawa.jetpack.arch.ui.composable.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.okawa.jetpack.arch.ui.composable.theme.componentMedium
import dev.chrisbanes.accompanist.coil.CoilImage

@Preview
@Composable
fun PreviewImages() {
    Column {
        Image(
            imageUrl = ""
        )
        RoundedCornerImage(
            imageUrl = "",
            modifier = Modifier.size(36.dp)
        )
        CircleImage(
            imageUrl = "",
            modifier = Modifier.size(36.dp)
        )
    }
}

@Composable
fun Image(imageUrl: String, contentDescription: String = "") {
    CoilImage(
        data = imageUrl as Any,
        contentDescription = contentDescription
    )
}

@Composable
fun RoundedCornerImage(
    imageUrl: String,
    modifier: Modifier = Modifier,
    contentDescription: String = ""
) {
    CoilImage(
        data = imageUrl,
        contentDescription = contentDescription,
        modifier = modifier.clip(RoundedCornerShape(componentMedium))
    )
}

@Composable
fun CircleImage(
    imageUrl: String,
    modifier: Modifier = Modifier,
    contentDescription: String = ""
) {
    CoilImage(
        data = imageUrl,
        contentDescription = contentDescription,
        modifier = modifier.clip(CircleShape)
    )
}