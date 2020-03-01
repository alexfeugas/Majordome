package fr.afe.majordome.entities;

import androidx.lifecycle.LiveData;

import java.util.List;

public class LocalSpaceKindDatasource implements SpaceKindDatasource {

    private final SpaceKindDAO mSpacekindDao;

    public LocalSpaceKindDatasource(SpaceKindDAO spacekindDao) {
        mSpacekindDao = spacekindDao;
    }

    @Override
    public LiveData<List<SpaceKindEntity>> getAll() {
        return mSpacekindDao.getAll();
    }

    @Override
    public void insert(SpaceKindEntity spaceKindEntity) {
        mSpacekindDao.insert(spaceKindEntity);
    }

    @Override
    public void delete(SpaceKindEntity SpaceEntity) {
        mSpacekindDao.delete(SpaceEntity);
    }

    @Override
    public void update(SpaceKindEntity SpaceEntity) {
        mSpacekindDao.update(SpaceEntity);
    }
}

