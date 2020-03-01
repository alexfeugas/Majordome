package fr.afe.majordome.entities;

import androidx.lifecycle.LiveData;

import java.util.List;

public interface SpaceDatasource {

    LiveData<List<SpaceEntity>> getAll();
    void insert(SpaceEntity spaceEntity);
    void delete(SpaceEntity spaceEntity);
    void update(SpaceEntity spaceEntity);
}
