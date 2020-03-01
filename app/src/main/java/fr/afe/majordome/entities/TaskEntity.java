package fr.afe.majordome.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Task")
public class TaskEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "TaskId")
    public int taskId;

    @ColumnInfo(name = "TaskName")
    public String taskName;

    @ColumnInfo(name = "TaskDescription")
    public String taskDescription;

    @ColumnInfo(name = "TaskPeriodicity")
    public int taskPeriodicity;

    @ColumnInfo(name = "ReferentTaskKind")
    public int referentTaskKind;

}
