package fr.afe.majordome.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "Space")
public class SpaceEntity implements Serializable {

    public SpaceEntity(int spaceId, String spaceName, boolean b) {
        this.spaceId = spaceId;
        this.spaceName = spaceName;
    }

    public SpaceEntity() {

    }
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "SpaceId")
    public int spaceId;

    @ColumnInfo(name = "SpaceName")
    public String spaceName;
}
