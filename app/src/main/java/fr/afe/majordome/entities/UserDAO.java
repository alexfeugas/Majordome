package fr.afe.majordome.entities;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDAO {
    @Query("SELECT * FROM user")
    LiveData<List<UserEntity>> getAll();

    @Insert
    void insert(UserEntity userEntity);

    @Delete
    void delete(UserEntity userEntity);

    @Update
    void update(UserEntity userEntity);
}
