package com.simpletasks.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.simpletasks.ui.components.AppTabRow
import com.simpletasks.ui.components.TaskListComponent

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier,
        topBar = { TopAppbar() }
    ) {

        //Use ViewModels to Persist
        var tabIndex by remember { mutableStateOf(0) }
        val tabs = listOf("All Tasks", "Completed Tasks")
        val taskList = listOf<String>("Task 1", "Task 2", "Task 3")
        //
        Box(modifier = modifier.padding(it)) {
            Column(Modifier.fillMaxSize()) {
                AppTabRow(listOfTabs = tabs,
                    currentTabIndex = tabIndex,
                    onTabSelected = { selectedTabIndex ->
                        tabIndex = selectedTabIndex
                    }
                )
                when (tabIndex) {
                    0 -> TaskListComponent(listOfTasks = taskList)
                    1 -> TaskListComponent(listOfTasks = taskList.filter { task -> task.startsWith("Completed") })
                }
            }
            FloatingActionButton(
                onClick = { /*TODO*/ },
                shape = CircleShape,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 32.dp, bottom = 32.dp)
            ) {
                Icon(contentDescription = "Add new task", imageVector = Icons.Default.Add)
            }
        }

    }
}

@Composable
fun TopAppbar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(top = 16.dp, bottom = 16.dp, start = 8.dp, end = 8.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background),
        horizontalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Simple Tasks",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge
        )
    }
}

