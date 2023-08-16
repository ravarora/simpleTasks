package com.simpletasks.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TaskDetails(taskId: String? = null, modifier: Modifier = Modifier) {
    Text(text = "Task Details screen with taskId: $taskId")
}