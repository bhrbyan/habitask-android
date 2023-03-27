package id.habitask.database.dao

import androidx.room.Dao
import androidx.room.Insert
import id.habitask.database.entity.TaskEntity

@Dao
interface TaskDao {

    @Insert
    suspend fun saveTask(task: TaskEntity)

}