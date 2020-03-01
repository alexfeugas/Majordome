package fr.afe.majordome.entities;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TaskExecutionDAO {
    @Query("SELECT * FROM taskexecution")
    LiveData<List<TaskExecutionEntity>> getAll();

    @Insert
    void insert(TaskExecutionEntity taskExecutionEntity);

    @Delete
    void delete(TaskExecutionEntity taskExecutionEntity);

    @Update
    void update(TaskExecutionEntity taskExecutionEntity);
}
