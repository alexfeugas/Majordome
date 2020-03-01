package fr.afe.majordome.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(primaryKeys = {"ProjectId", "UserId"})
public class ProjectMemberEntity {

    @ColumnInfo(name = "ProjectId")
   public int projectId;

    @ColumnInfo(name = "UserId")
   public int userId;

    @ColumnInfo(name = "IsCreator")
   public boolean isCreator;

}
