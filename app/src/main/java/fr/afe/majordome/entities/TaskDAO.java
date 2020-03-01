package fr.afe.majordome.entities;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TaskDAO {
    @Query("SELECT * FROM task")
    LiveData<List<TaskEntity>> getAll();

    @Insert
    void insert(TaskEntity taskEntity);

    @Delete
    void delete(TaskEntity taskEntity);

    @Update
    void update(TaskEntity taskEntity);

    @Query("SELECT * FROM task where ReferentTaskKind = :taskId")
    LiveData<List<TaskEntity>>  findBySpaceId(int taskId);
}
