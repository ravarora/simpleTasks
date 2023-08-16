package com.simpletasks.ui.components

import androidx.navigation.NavType
import androidx.navigation.navArgument

interface NavigationRoute {
    val route: String
}

interface TabbedNavigationRoute : NavigationRoute {
    val tabIndex: Int
    val title: String
}

object HomeScreenRoute : NavigationRoute {
    override val route = "homeScreen"
}

object AllTasksRoute : TabbedNavigationRoute {
    override val tabIndex = 0
    override val route = "allTasks"
    override val title = "All Tasks"
}

object CompletedTasksRoute : TabbedNavigationRoute {
    override val tabIndex = 1
    override val route = "completedTasks"
    override val title = "Completed Tasks"
}

object CreateNewTaskRoute : NavigationRoute {
    override val route = "createNewTask"
}

object TaskDetailsRoute : NavigationRoute {
    private const val routeBase = "taskDetails"
    const val taskIdArg = "taskId"
    override val route = "$routeBase/{$taskIdArg}"
    val arguments = listOf(navArgument(taskIdArg) { type = NavType.StringType })

    fun createTaskDetailRoute(taskId: String) = "$routeBase/$taskId"
}

val tabbedRoutes = listOf(AllTasksRoute, CompletedTasksRoute)