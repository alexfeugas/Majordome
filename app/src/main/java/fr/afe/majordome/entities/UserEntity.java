package fr.afe.majordome.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "User")
public class UserEntity {
    @PrimaryKey
    @ColumnInfo(name = "UserId")
    public int userId;
    @ColumnInfo (name = "UserName")
    public String userName;
    @ColumnInfo(name = "IsMainUser")
    public boolean isMainUser;
}
