package fr.afe.majordome.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "SpaceKind")
public class SpaceKindEntity {

    @PrimaryKey
    @ColumnInfo(name = "SpaceKindId")
    public int spaceKindId;

    @ColumnInfo(name = "SpaceKindName")
    public String spaceKindName;

    @ColumnInfo(name = "SpaceKindComment")
    public String spaceKindComment;
}
