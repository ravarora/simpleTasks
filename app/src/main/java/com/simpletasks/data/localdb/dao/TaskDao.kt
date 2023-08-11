package com.simpletasks.data.localdb.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.simpletasks.data.localdb.entities.TaskDbEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Insert
    suspend fun insertNewTask(task: TaskDbEntity)

    @Update
    suspend fun updateTask(task: TaskDbEntity)

    @Query("Select * from tasks")
    suspend fun getAllTasks() : List<TaskDbEntity>

    @Query("Select * from tasks")
    fun getAllTasksAndObserve() : Flow<List<TaskDbEntity>>

    @Query("Select * from tasks where id =:id")
    suspend fun getTaskById(id :String) : List<TaskDbEntity>

    @Query("Select * from tasks where id =:id")
    fun getTaskByIdAndObserve(id :String) : Flow<List<TaskDbEntity>>

    @Delete
    suspend fun deleteTask(task: TaskDbEntity)
}