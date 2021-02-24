package com.okawa.jetpack.arch.ui.composable.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.okawa.jetpack.arch.R

@Composable
fun AppBar(
    title: @Composable RowScope.() -> Unit,
    @DrawableRes navigationIcon: Int = R.drawable.ic_architecture_24,
    onNavIconPressed: () -> Unit = { }
) {
    Column(
        modifier = Modifier.background(MaterialTheme.colors.primary.copy(alpha = 1.0f))
    ) {
        TopAppBar(
            title = { Row { title() } },
            elevation = 0.dp,
            contentColor = MaterialTheme.colors.onPrimary,
            navigationIcon = {
                IconButton(onClick = onNavIconPressed) {
                    Icon(
                        painter = painterResource(navigationIcon),
                        contentDescription = stringResource(R.string.app_name)
                    )
                }
            }
        )
        Divider()
    }
}