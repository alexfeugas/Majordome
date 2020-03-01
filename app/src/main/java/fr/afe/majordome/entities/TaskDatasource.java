package fr.afe.majordome.entities;

import androidx.lifecycle.LiveData;

import java.util.List;

public interface  TaskDatasource {
    LiveData<List<TaskEntity>> getAll();
    void insert(TaskEntity taskEntity);
    void delete(TaskEntity taskEntity);
    void update(TaskEntity taskEntity);
}
