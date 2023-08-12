package com.simpletasks.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun MainScreen(modifier: Modifier = Modifier) {

    Scaffold {
        Box(modifier = Modifier.padding(it).fillMaxSize()) {
            Text(text = "Hello World", modifier = Modifier.align(Alignment.Center))
        }
    }
}