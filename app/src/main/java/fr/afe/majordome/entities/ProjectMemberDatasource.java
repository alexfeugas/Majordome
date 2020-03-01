package fr.afe.majordome.entities;

import androidx.lifecycle.LiveData;

import java.util.List;

public interface ProjectMemberDatasource {

    LiveData<List<ProjectMemberEntity>> getAll();
    void insert(ProjectMemberEntity projectMemberEntity);
    void delete(ProjectMemberEntity projectMemberEntity);
    void update(ProjectMemberEntity projectMemberEntity);
}
