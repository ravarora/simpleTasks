package com.simpletasks.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.simpletasks.ui.models.Task

@Composable
fun TaskListComponent(listOfTasks: List<Task>, modifier: Modifier = Modifier) {
    if (listOfTasks.isEmpty()) {
        Box(modifier = modifier, contentAlignment = Alignment.Center) {
            Text(text = "No Tasks!")
        }
    } else {
        LazyColumn(
            modifier = modifier
        ) {
            items(listOfTasks) { task ->
                TaskListItem(task = task)
            }
        }
    }
}

@Composable
fun TaskListItem(task: Task, modifier: Modifier = Modifier) {
    ListItem(
        modifier = modifier,
        headlineContent = { Text(text = task.name) },
        leadingContent = { Checkbox(checked = false, onCheckedChange = {}) },
    )
    Divider(thickness = 1.dp)
}