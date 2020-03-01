package fr.afe.majordome.entities;

import androidx.lifecycle.LiveData;

import java.util.List;

public class LocalProjectMemberDatasource implements  ProjectMemberDatasource {

    private final ProjectMemberDAO mprojectMemberDao;

    public LocalProjectMemberDatasource(ProjectMemberDAO projectMemberDao) {
        mprojectMemberDao = projectMemberDao;
    }

    @Override
    public LiveData<List<ProjectMemberEntity>> getAll() {
        return mprojectMemberDao.getAll();
    }

    @Override
    public void insert(ProjectMemberEntity projectMemberEntity) {
        mprojectMemberDao.insert(projectMemberEntity);
    }

    @Override
    public void delete(ProjectMemberEntity projectMemberEntity) {
        mprojectMemberDao.delete(projectMemberEntity);
    }

    @Override
    public void update(ProjectMemberEntity projectMemberEntity) {
        mprojectMemberDao.update(projectMemberEntity);
    }
}
