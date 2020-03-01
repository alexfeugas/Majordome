package fr.afe.majordome.entities;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface SpaceDAO {
    @Query("SELECT * FROM space")
    LiveData<List<SpaceEntity>> getAll();

    @Insert
    void insert(SpaceEntity spaceEntity);

    @Delete
    void delete(SpaceEntity spaceEntity);

    @Update
    void update(SpaceEntity spaceEntity);

    @Query("DELETE FROM space")
    void deleteAll();
}
