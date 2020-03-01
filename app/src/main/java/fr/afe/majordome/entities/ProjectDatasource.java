package fr.afe.majordome.entities;

import androidx.lifecycle.LiveData;

import java.util.List;

public interface ProjectDatasource {

    public LiveData<List<ProjectEntity>> findAll();

    public ProjectEntity findById();
    public void create(ProjectEntity projectEntity);
    public void update(ProjectEntity projectEntity);
    public void delete(ProjectEntity projectEntity);
}
