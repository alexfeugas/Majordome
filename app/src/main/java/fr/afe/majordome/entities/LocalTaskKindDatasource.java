package fr.afe.majordome.entities;

import androidx.lifecycle.LiveData;

import java.util.List;

public class LocalTaskKindDatasource implements TaskKindDatasource {

    private final TaskKindDAO mTaskKindDAO;

    public LocalTaskKindDatasource(TaskKindDAO taskKindDAO) {
        this.mTaskKindDAO = taskKindDAO;
    }

    @Override
    public LiveData<List<TaskKindEntity>> getAll() {
        return mTaskKindDAO.getAll();
    }

    @Override
    public void insert(TaskKindEntity taskKindEntity) {
        mTaskKindDAO.insert(taskKindEntity);
    }

    @Override
    public void delete(TaskKindEntity taskKindEntity) {
        mTaskKindDAO.delete(taskKindEntity);
    }

    @Override
    public void update(TaskKindEntity taskKindEntity) {
        mTaskKindDAO.update(taskKindEntity);
    }
}
