package fr.afe.majordome.entities;

import androidx.lifecycle.LiveData;

import java.util.List;

public class LocalProjectDatasource implements ProjectDatasource {

    private final ProjectDAO mprojectDao;

    public LocalProjectDatasource(ProjectDAO projectDao) {
        mprojectDao = projectDao;
    }

    @Override
    public LiveData<List<ProjectEntity>> findAll() {
        return mprojectDao.getAll();
    }

    @Override
    public ProjectEntity findById() {
        return null; // FIXME
    }

    @Override
    public void create(ProjectEntity projectEntity) {
        mprojectDao.insert(projectEntity);
    }

    @Override
    public void update(ProjectEntity projectEntity) {
        mprojectDao.update(projectEntity);
    }

    @Override
    public void delete(ProjectEntity projectEntity) {
        mprojectDao.delete(projectEntity);
    }
}
