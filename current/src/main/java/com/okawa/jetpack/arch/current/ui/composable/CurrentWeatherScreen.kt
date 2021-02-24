package com.okawa.jetpack.arch.current.ui.composable

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.constraintlayout.compose.ConstraintLayout
import com.okawa.jetpack.arch.current.ui.model.CurrentWeather
import com.okawa.jetpack.arch.ui.composable.component.AppBar
import com.okawa.jetpack.arch.ui.composable.theme.JetpackArchTheme

@Composable
fun SearchScreen(
    title: String,
    characters: State<List<CurrentWeather>>
) {
    val charactersState by remember { mutableStateOf(characters) }

    JetpackArchTheme {
        Scaffold(
            topBar = { AppBar(title =  { Text(text = title) }) },
            content = {
                if (charactersState.value.isEmpty()) {
                    ContentEmpty()
                } else {
                    //ContentSuccess(characters = characters.value)
                }
            }
        )
    }
}

@Composable
fun ContentSuccess(
    currentWeather: CurrentWeather,
    modifier: Modifier = Modifier
) {
    val currentWeatherState by remember { mutableStateOf(currentWeather) }

    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        val (
            nameText,
            speciesText,
            createdAtText,
            descriptionText,
            logoImage
        ) = createRefs()

        /*
        Text(
            text = characterState.name,
            style = MaterialTheme.typography.h6,
            maxLines = 1,
            modifier = Modifier
                .constrainAs(nameText) {
                    top.linkTo(parent.top, componentMedium)
                    bottom.linkTo(speciesText.top, componentSmall)
                    linkTo(
                        start = logoImage.end,
                        startMargin = componentMedium,
                        end = parent.end,
                        endMargin = componentMedium,
                        bias = 0f
                    )
                }
        )

        Text(
            text = characterState.species,
            style = MaterialTheme.typography.body2,
            maxLines = 1,
            modifier = Modifier
                .constrainAs(speciesText) {
                    top.linkTo(nameText.bottom, componentSmall)
                    bottom.linkTo(createdAtText.top, componentMedium)
                    linkTo(
                        start = logoImage.end,
                        startMargin = componentMedium,
                        end = parent.end,
                        endMargin = componentMedium,
                        bias = 0f
                    )
                }
        )

        Text(
            text = characterState.created.toString(),
            style = MaterialTheme.typography.body2,
            maxLines = 1,
            modifier = Modifier
                .constrainAs(createdAtText) {
                    top.linkTo(speciesText.bottom, componentSmall)
                    bottom.linkTo(descriptionText.top, componentMedium)
                    linkTo(
                        start = logoImage.end,
                        startMargin = componentMedium,
                        end = parent.end,
                        endMargin = componentMedium,
                        bias = 0f
                    )
                }
        )

        Text(
            text = String.format(characterState.location),
            style = MaterialTheme.typography.body2,
            maxLines = 2,
            modifier = Modifier
                .constrainAs(descriptionText) {
                    top.linkTo(createdAtText.bottom, componentSmall)
                    bottom.linkTo(parent.bottom, componentMedium)
                    linkTo(
                        start = logoImage.end,
                        startMargin = componentMedium,
                        end = parent.end,
                        endMargin = componentMedium,
                        bias = 0f
                    )
                }
        )

        CoilImage(
            data = characterState.image,
            contentDescription = "Character picture",
            modifier = Modifier
                .size(96.dp)
                .constrainAs(logoImage) {
                    top.linkTo(
                        anchor = parent.top,
                        margin = componentMedium
                    )
                    bottom.linkTo(
                        anchor = parent.bottom,
                        margin = componentMedium
                    )
                    start.linkTo(anchor = parent.start)
                }
                .clip(RoundedCornerShape(componentMedium))
        )
         */
    }
}

@Composable
fun ContentEmpty() {
    Text(
        text = "No matching results",
        style = MaterialTheme.typography.h6,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxSize()
    )
}