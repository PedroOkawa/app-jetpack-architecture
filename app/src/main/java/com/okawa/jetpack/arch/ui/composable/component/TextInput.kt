package com.okawa.jetpack.arch.ui.composable.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.okawa.jetpack.arch.ui.composable.theme.componentMedium
import com.okawa.jetpack.arch.ui.composable.theme.componentXLarge

@Preview
@Composable
fun PreviewTextInput() {
    TextInput(
        hint = "Type something",
        onInputChanged = { /*TODO*/ },
        drawableResStart = null
    )
}

@Composable
fun TextInput(
    hint: String,
    onInputChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
    iconStartModifier: Modifier = Modifier,
    iconInputModifier: Modifier = Modifier,
    iconEndModifier: Modifier = Modifier,
    @DrawableRes drawableResStart: Int? = null,
    @DrawableRes drawableResEnd: Int? = null
) {
    var textFieldState by remember { mutableStateOf(TextFieldValue("")) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(componentXLarge)
            .background(
                shape = MaterialTheme.shapes.medium,
                color = MaterialTheme.colors.background
            )
    ) {
        if (drawableResStart != null) {
            Icon(
                painter = painterResource(id = drawableResStart),
                contentDescription = null,
                modifier = iconStartModifier.padding(componentMedium)
            )
        }
        TextField(
            value = textFieldState,
            onValueChange = {
                    newValueState ->
                textFieldState = newValueState
                onInputChanged(textFieldState.text)
            },
            label = {
                Text(
                    text = hint,
                    style = MaterialTheme.typography.body2
                )
            },
            modifier = Modifier
                .background(Color.Transparent)
                .weight(1.0f)
        )
        if (drawableResEnd != null) {
            Icon(
                painter = painterResource(id = drawableResEnd),
                contentDescription = null,
                modifier = iconEndModifier.padding(componentMedium)
            )
        }
    }
}