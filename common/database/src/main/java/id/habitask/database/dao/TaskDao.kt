package id.habitask.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import id.habitask.database.entity.TaskEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Insert
    suspend fun saveTask(task: TaskEntity)

    @Query("SELECT * FROM task_entity")
    fun getTasks(): Flow<List<TaskEntity>>

    @Query("UPDATE task_entity SET checked = :checked WHERE id = :id")
    suspend fun checkTask(id: Long, checked: Boolean)

}