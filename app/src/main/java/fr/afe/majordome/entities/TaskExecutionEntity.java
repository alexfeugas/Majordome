package fr.afe.majordome.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.TypeConverters;

import java.sql.Date;

@Entity (tableName = "TaskExecution", primaryKeys = {"taskId", "projectId", "userId", "date"})
@TypeConverters(DateConverter.class)
public class TaskExecutionEntity {
   @NonNull
    public int taskId;
    @NonNull
    public int projectId;
    @NonNull
    public int userId;
    @NonNull
    public Date date;
    public String comment;

}
