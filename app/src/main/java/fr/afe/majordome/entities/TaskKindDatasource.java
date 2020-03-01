package fr.afe.majordome.entities;

import androidx.lifecycle.LiveData;

import java.util.List;

public interface  TaskKindDatasource {
    LiveData<List<TaskKindEntity>> getAll();
    void insert(TaskKindEntity taskKindEntity);
    void delete(TaskKindEntity taskKindEntity);
    void update(TaskKindEntity taskKindEntity);
}
