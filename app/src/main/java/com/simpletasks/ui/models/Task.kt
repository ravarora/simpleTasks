package com.simpletasks.ui.models

import com.simpletasks.data.localdb.entities.TaskStatus
import java.text.SimpleDateFormat
import java.util.UUID

data class Task(
    val id: String,
    val name: String,
    val description: String,
    val status: TaskStatus,
    val createdTime: Long,
    val updatedTime: Long?,
    val dueDate: Long?
)

val dummyTaskList = mutableListOf<Task>(
    Task(
        id = UUID.randomUUID().toString(),
        name = "Task 1",
        description = "Task 1 Description goes here",
        status = TaskStatus.NEW,
        createdTime = SimpleDateFormat("dd/MM/yyyy").parse("23/01/2023")!!.time,
        updatedTime = null,
        dueDate = null
    ),
    Task(
        id = UUID.randomUUID().toString(),
        name = "Task 2",
        description = "Task 2 Description goes here",
        status = TaskStatus.NEW,
        createdTime = SimpleDateFormat("dd/MM/yyyy").parse("09/02/2023")!!.time,
        updatedTime = null,
        dueDate = null
    ),
    Task(
        id = UUID.randomUUID().toString(),
        name = "Task 3",
        description = "Task 3 Description goes here",
        status = TaskStatus.COMPLETED,
        createdTime = SimpleDateFormat("dd/MM/yyyy").parse("12/03/2023")!!.time,
        updatedTime = null,
        dueDate = null
    ),
    Task(
        id = UUID.randomUUID().toString(),
        name = "Task 4",
        description = "Task 4 Description goes here",
        status = TaskStatus.COMPLETED,
        createdTime = SimpleDateFormat("dd/MM/yyyy").parse("03/04/2023")!!.time,
        updatedTime = null,
        dueDate = null
    ),
    Task(
        id = UUID.randomUUID().toString(),
        name = "Task 1",
        description = "Task 1 Description goes here",
        status = TaskStatus.NEW,
        createdTime = SimpleDateFormat("dd/MM/yyyy").parse("23/01/2023")!!.time,
        updatedTime = null,
        dueDate = null
    ),
    Task(
        id = UUID.randomUUID().toString(),
        name = "Task 5",
        description = "Task 5 Description goes here",
        status = TaskStatus.NEW,
        createdTime = SimpleDateFormat("dd/MM/yyyy").parse("15/05/2023")!!.time,
        updatedTime = null,
        dueDate = null
    ),
    Task(
        id = UUID.randomUUID().toString(),
        name = "Task 6",
        description = "Task 6 Description goes here",
        status = TaskStatus.NEW,
        createdTime = SimpleDateFormat("dd/MM/yyyy").parse("23/06/2023")!!.time,
        updatedTime = null,
        dueDate = null
    ),
    Task(
        id = UUID.randomUUID().toString(),
        name = "Task 7",
        description = "Task 7 Description goes here",
        status = TaskStatus.COMPLETED,
        createdTime = SimpleDateFormat("dd/MM/yyyy").parse("14/01/2023")!!.time,
        updatedTime = null,
        dueDate = null
    ),
    Task(
        id = UUID.randomUUID().toString(),
        name = "Task 8",
        description = "Task 8 Description goes here",
        status = TaskStatus.NEW,
        createdTime = SimpleDateFormat("dd/MM/yyyy").parse("20/06/2023")!!.time,
        updatedTime = null,
        dueDate = null
    ),
    Task(
        id = UUID.randomUUID().toString(),
        name = "Task 9",
        description = "Task 9 Description goes here",
        status = TaskStatus.NEW,
        createdTime = SimpleDateFormat("dd/MM/yyyy").parse("07/08/2023")!!.time,
        updatedTime = null,
        dueDate = null
    ),
    Task(
        id = UUID.randomUUID().toString(),
        name = "Task 10",
        description = "Task 10 Description goes here",
        status = TaskStatus.NEW,
        createdTime = SimpleDateFormat("dd/MM/yyyy").parse("17/05/2023")!!.time,
        updatedTime = null,
        dueDate = null
    ),
    Task(
        id = UUID.randomUUID().toString(),
        name = "Task 11",
        description = "Task 11 Description goes here",
        status = TaskStatus.NEW,
        createdTime = SimpleDateFormat("dd/MM/yyyy").parse("07/08/2023")!!.time,
        updatedTime = null,
        dueDate = null
    ),
    Task(
        id = UUID.randomUUID().toString(),
        name = "Task 12",
        description = "Task 12 Description goes here",
        status = TaskStatus.COMPLETED,
        createdTime = SimpleDateFormat("dd/MM/yyyy").parse("07/08/2023")!!.time,
        updatedTime = null,
        dueDate = null
    )
)
