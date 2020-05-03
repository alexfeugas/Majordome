package fr.afe.majordome.entities;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StockDAO {

    @Query("SELECT * FROM stock")
    LiveData<List<StockEntity>> getAll();

    @Insert
    void insert(StockEntity stockEntity);

    @Delete
    void delete(StockEntity stockEntity);

    @Update
    void update(StockEntity stockEntity);

/*
    @Query("SELECT * FROM task where ReferentTaskKind = :taskId")
    LiveData<List<TaskEntity>>  findBySpaceId(int taskId);
*/
}
