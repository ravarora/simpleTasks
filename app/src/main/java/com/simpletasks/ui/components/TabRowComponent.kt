package com.simpletasks.ui.components

import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppTabRow(
    currentTabIndex: Int,
    tabbedRoutes: List<TabbedNavigationRoute>,
    onTabSelected: (TabbedNavigationRoute) -> Unit,
    modifier: Modifier = Modifier
) {
    TabRow(selectedTabIndex = currentTabIndex, modifier = modifier) {
        tabbedRoutes.forEach { tab ->
            Tab(selected = currentTabIndex == tab.tabIndex,
                onClick = { onTabSelected(tab) },
                text = { Text(tab.title) })
        }
    }
}