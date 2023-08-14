package com.simpletasks.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppTabRow(
    currentTabIndex: Int,
    listOfTabs: List<String>,
    onTabSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier.fillMaxWidth()) {
        androidx.compose.material3.TabRow(selectedTabIndex = currentTabIndex) {
            listOfTabs.forEachIndexed { index, title ->
                Tab(
                    selected = currentTabIndex == index,
                    onClick = { onTabSelected(index) },
                    text = { Text(title) })
            }
        }
    }
}