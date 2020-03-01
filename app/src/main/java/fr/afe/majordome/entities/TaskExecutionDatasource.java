package fr.afe.majordome.entities;

import androidx.lifecycle.LiveData;

import java.util.List;

public interface  TaskExecutionDatasource {

    LiveData<List<TaskExecutionEntity>> getAll();
    void insert(TaskExecutionEntity taskExecutionEntity);
    void delete(TaskExecutionEntity taskExecutionEntity);
    void update(TaskExecutionEntity taskExecutionEntity);
}
