package fr.afe.majordome.entities;

import androidx.lifecycle.LiveData;

import java.util.List;

public class LocalTaskExecutionDatasource implements TaskExecutionDatasource {

    private final TaskExecutionDAO mTaskExecutionDAO;

    public LocalTaskExecutionDatasource(TaskExecutionDAO taskExecutionDAO) {
        this.mTaskExecutionDAO = taskExecutionDAO;
    }

    @Override
    public LiveData<List<TaskExecutionEntity>> getAll() {
        return mTaskExecutionDAO.getAll();
    }

    @Override
    public void insert(TaskExecutionEntity taskExecutionEntity) {
        mTaskExecutionDAO.insert(taskExecutionEntity);
    }

    @Override
    public void delete(TaskExecutionEntity taskExecutionEntity) {
        mTaskExecutionDAO.delete(taskExecutionEntity);
    }

    @Override
    public void update(TaskExecutionEntity taskExecutionEntity) {
        mTaskExecutionDAO.update(taskExecutionEntity);
    }
}
