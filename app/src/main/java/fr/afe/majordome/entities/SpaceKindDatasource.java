package fr.afe.majordome.entities;

import androidx.lifecycle.LiveData;

import java.util.List;

public interface SpaceKindDatasource {
    LiveData<List<SpaceKindEntity>> getAll();
    void insert(SpaceKindEntity spaceEntity);
    void delete(SpaceKindEntity spaceKindEntity);
    void update(SpaceKindEntity spaceKindEntity);
}
