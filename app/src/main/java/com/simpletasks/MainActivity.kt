package com.simpletasks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.simpletasks.ui.components.TopAppBar
import com.simpletasks.ui.screens.CreateNewTaskForm
import com.simpletasks.ui.screens.HomeScreen
import com.simpletasks.ui.screens.TaskDetails
import com.simpletasks.ui.theme.SimpleTasksTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            var title by remember { mutableStateOf("Simple Tasks") }
            var showBackButton by remember { mutableStateOf(false) }
            LaunchedEffect(navController) {
                navController.currentBackStackEntryFlow.collect { backStackEntry ->
                    title = when (backStackEntry.destination.route) {
                        "homeScreen" -> "Simple Tasks"
                        "createNewTask" -> "Create New Task"
                        else -> "Task Details"
                    }
                    showBackButton = navController.previousBackStackEntry != null
                }
            }

            SimpleTasksTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = title,
                                showBackButton = showBackButton,
                                onBackButtonPressed = { navController.navigateUp() })
                        }
                    ) { innerPaddingValues ->
                        NavHost(
                            navController = navController,
                            startDestination = "homeScreen",
                            modifier = Modifier.padding(innerPaddingValues),
                        ) {
                            composable(route = "homeScreen") {
                                HomeScreen(
                                    onFabClicked = { navController.navigate("createNewTask") },
                                    onListItemClicked = { taskId -> navController.navigate("taskDetails/$taskId)") }
                                )
                            }
                            composable(route = "createNewTask") {
                                CreateNewTaskForm()
                            }
                            composable(
                                route = "taskDetails/{taskId}",
                                arguments = listOf(navArgument("taskId") {
                                    type = NavType.StringType
                                })
                            ) { navBackStackEntry ->
                                val taskId = navBackStackEntry.arguments?.getString("taskId")
                                TaskDetails(taskId = taskId)
                            }
                        }
                    }
                }
            }
        }
    }
}
