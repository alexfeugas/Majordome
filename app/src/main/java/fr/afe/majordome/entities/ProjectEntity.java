package fr.afe.majordome.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

@Entity (tableName = "Project")
public class ProjectEntity {
    @PrimaryKey
    @ColumnInfo(name = "ProjectId")
    public int projectId;

    @ColumnInfo(name = "ProjectName")
    public String projectName;

    @ColumnInfo(name = "ProjectDescription")
    public String projectDescription;

    @ColumnInfo(name = "UserCreator")
    @ForeignKey(
        entity = UserEntity.class,
            parentColumns = "userId",
            childColumns = "uUserCreator"
    )
    public int userCreator;

}
