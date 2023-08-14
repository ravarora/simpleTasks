package com.simpletasks.data.localdb.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class TaskDbEntity(
    @PrimaryKey val id: String,
    val name: String,
    val description: String,
    val status: TaskStatus,
    val createdTime: Long,
    val updatedTime: Long,
    val dueDate: Long
)

enum class TaskStatus {
    NEW,
    STARTED,
    COMPLETED
}