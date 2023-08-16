package com.simpletasks.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.simpletasks.data.localdb.entities.TaskStatus
import com.simpletasks.ui.components.AppTabRow
import com.simpletasks.ui.components.TaskListComponent
import com.simpletasks.ui.models.dummyTaskList

@Composable
fun HomeScreen(
    onFabClicked: () -> Unit,
    onListItemClicked: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    //Use ViewModels to Persist
    var tabIndex by remember { mutableStateOf(0) }
    val tabs = listOf("All Tasks", "Completed Tasks")
    val taskList = dummyTaskList
    //

    Box(modifier = modifier) {
        Column(Modifier.fillMaxSize()) {
            AppTabRow(listOfTabs = tabs,
                currentTabIndex = tabIndex,
                onTabSelected = { selectedTabIndex ->
                    tabIndex = selectedTabIndex
                }
            )
            when (tabIndex) {
                0 -> TaskListComponent(
                    listOfTasks = taskList,
                    onListItemSelected = onListItemClicked,
                    modifier = Modifier.fillMaxSize()
                )

                1 -> TaskListComponent(
                    listOfTasks = taskList.filter { task -> task.status == TaskStatus.COMPLETED },
                    onListItemSelected = onListItemClicked,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
        NewTaskFab(
            onFabClicked = onFabClicked,
            Modifier
                .padding(end = 24.dp, bottom = 24.dp)
                .align(
                    Alignment.BottomEnd
                )
        )
    }
}

@Composable
fun NewTaskFab(onFabClicked: () -> Unit, modifier: Modifier = Modifier) {
    FloatingActionButton(
        onClick = { onFabClicked() },
        shape = CircleShape,
        modifier = modifier.padding(end = 16.dp, bottom = 16.dp)
    ) {
        Icon(contentDescription = "Add new task", imageVector = Icons.Default.Add)
    }
}

