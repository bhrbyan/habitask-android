package id.habitask.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import id.habitask.database.entity.TaskEntity

@Dao
interface TaskDao {

    @Insert
    suspend fun saveTask(task: TaskEntity)

    @Query("SELECT * FROM task_entity")
    suspend fun getTasks(): List<TaskEntity>

    @Query("UPDATE task_entity SET checked = :checked WHERE id = :id")
    suspend fun checkTask(id: Long, checked: Boolean)

}