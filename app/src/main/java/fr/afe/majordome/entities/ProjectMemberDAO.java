package fr.afe.majordome.entities;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProjectMemberDAO {

    @Query("SELECT * FROM ProjectMemberEntity")
    LiveData<List<ProjectMemberEntity>> getAll();

    @Insert
    void insert(ProjectMemberEntity projectMemberEntity);

    @Delete
    void delete(ProjectMemberEntity projectMemberEntity);

    @Update
    void update(ProjectMemberEntity projectMemberEntity);
}
