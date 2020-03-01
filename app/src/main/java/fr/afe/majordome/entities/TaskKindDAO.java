package fr.afe.majordome.entities;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface TaskKindDAO {
    @Query("SELECT * FROM taskkind")
    LiveData<List<TaskKindEntity>> getAll();

    @Insert
    void insert(TaskKindEntity taskKindEntity);

    @Delete
    void delete(TaskKindEntity taskKindEntity);

    @Update
    void update(TaskKindEntity taskKindEntity);
}
