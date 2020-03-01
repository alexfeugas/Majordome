package fr.afe.majordome.entities;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface ProjectDAO {
    @Query("SELECT * FROM project")
    LiveData<List<ProjectEntity>> getAll();

    @Insert
    void insert(ProjectEntity projectEntity);

    @Delete
    void delete(ProjectEntity projectEntity);

    @Update
    void update(ProjectEntity projectEntity);
}
