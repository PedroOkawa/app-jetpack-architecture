package com.okawa.jetpack.arch.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.okawa.jetpack.arch.R
import com.okawa.jetpack.arch.ui.composable.theme.JetpackArchTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackArchTheme { setContentView(R.layout.activity_main) }
        }
    }
}