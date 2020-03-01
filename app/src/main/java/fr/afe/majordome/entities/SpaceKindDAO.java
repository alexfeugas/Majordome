package fr.afe.majordome.entities;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface SpaceKindDAO {
    @Query("SELECT * FROM spacekind")
    LiveData<List<SpaceKindEntity>> getAll();

    @Insert
    void insert(SpaceKindEntity spaceEntity);

    @Delete
    void delete(SpaceKindEntity spaceKindEntity);

    @Update
    void update(SpaceKindEntity spaceKindEntity);
}
