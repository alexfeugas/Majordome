package fr.afe.majordome.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "TaskKind")
public class TaskKindEntity {
    @PrimaryKey
    public int taskKindId;
    public String taskKindName;
    public String taskKindComment;
    public int taskKindPeriodicity;
}
