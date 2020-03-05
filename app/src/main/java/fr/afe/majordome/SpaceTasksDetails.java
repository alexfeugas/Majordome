package fr.afe.majordome;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

import fr.afe.majordome.entities.SpaceEntity;
import fr.afe.majordome.entities.TaskEntity;

public class SpaceTasksDetails {

    public SpaceTasksDetails() {

    }

    @Embedded
    private SpaceEntity spaceEntity;

    @Relation(parentColumn = "SpaceId", entityColumn = "ReferentTaskKind", entity = TaskEntity.class)
    private List<TaskEntity> tasks;


    public SpaceEntity getSpaceEntity() {
        return spaceEntity;
    }

    public void setSpaceEntity(SpaceEntity spaceEntity) {
        this.spaceEntity = spaceEntity;
    }

    public List<TaskEntity> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskEntity> tasks) {
        this.tasks = tasks;
    }
}
