package com.simpletasks.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.simpletasks.ui.components.AppTabRow
import com.simpletasks.ui.components.TaskListComponent
import com.simpletasks.ui.components.TopAppBar

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    //Use ViewModels to Persist
    var tabIndex by remember { mutableStateOf(0) }
    val tabs = listOf("All Tasks", "Completed Tasks")
    val taskList = listOf<String>("Task 1", "Task 2", "Task 3", "Completed Task 4")
    //

    Scaffold(
        modifier = modifier,
        topBar = { TopAppBar() },
        floatingActionButton = { NewTaskFab() },
        floatingActionButtonPosition = FabPosition.End
    ) {
        Column(
            modifier
                .padding(it)
                .fillMaxSize()
        ) {
            AppTabRow(listOfTabs = tabs,
                currentTabIndex = tabIndex,
                onTabSelected = { selectedTabIndex ->
                    tabIndex = selectedTabIndex
                }
            )
            when (tabIndex) {
                0 -> TaskListComponent(listOfTasks = taskList, modifier = Modifier.fillMaxSize())
                1 -> TaskListComponent(
                    listOfTasks = taskList.filter { task -> task.startsWith("Completed") },
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

@Composable
fun NewTaskFab(modifier: Modifier = Modifier) {
    FloatingActionButton(
        onClick = { /*TODO*/ },
        shape = CircleShape,
        modifier = modifier.padding(end = 16.dp, bottom = 16.dp)
    ) {
        Icon(contentDescription = "Add new task", imageVector = Icons.Default.Add)
    }
}

