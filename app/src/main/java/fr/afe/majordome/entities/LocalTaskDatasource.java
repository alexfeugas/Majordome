package fr.afe.majordome.entities;

import androidx.lifecycle.LiveData;

import java.util.List;

public class LocalTaskDatasource implements TaskDatasource {

    private final TaskDAO mTaskDao;

    public LocalTaskDatasource(TaskDAO taskDAO) {
        mTaskDao = taskDAO;
    }

    @Override
    public LiveData<List<TaskEntity>> getAll() {
        return mTaskDao.getAll();
    }

    @Override
    public void insert(TaskEntity taskEntity) {
        mTaskDao.insert(taskEntity);
    }

    @Override
    public void delete(TaskEntity taskEntity) {
        mTaskDao.delete(taskEntity);
    }

    @Override
    public void update(TaskEntity taskEntity) {
        mTaskDao.update(taskEntity);
    }
}
