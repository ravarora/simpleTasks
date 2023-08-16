package com.simpletasks.ui.components

import androidx.compose.foundation.clickable
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
fun TaskListComponent(
    onListItemSelected: (String) -> Unit,
    listOfTasks: List<Task>,
    modifier: Modifier = Modifier
) {
    if (listOfTasks.isEmpty()) {
        Box(modifier = modifier, contentAlignment = Alignment.Center) {
            Text(text = "No Tasks!")
        }
    } else {
        LazyColumn(
            modifier = modifier
        ) {
            items(listOfTasks) { task ->
                TaskListItem(task = task, onTaskItemClicked = onListItemSelected)
            }
        }
    }
}

@Composable
fun TaskListItem(task: Task, onTaskItemClicked: (String) -> Unit, modifier: Modifier = Modifier) {
    ListItem(
        modifier = modifier,
        headlineContent = {
            Text(
                text = task.name,
                Modifier.clickable(true) { onTaskItemClicked(task.id) })
        },
        leadingContent = { Checkbox(checked = false, onCheckedChange = {}) },
    )
    Divider(thickness = 1.dp)
}