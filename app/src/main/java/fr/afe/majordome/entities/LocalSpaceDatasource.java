package fr.afe.majordome.entities;

import androidx.lifecycle.LiveData;

import java.util.List;

public class LocalSpaceDatasource implements SpaceDatasource {

    private final SpaceDAO mSpaceDao;

    public LocalSpaceDatasource(SpaceDAO spaceDao) {
        mSpaceDao = spaceDao;
    }

    @Override
    public LiveData<List<SpaceEntity>> getAll() {
        return mSpaceDao.getAll();
    }

    @Override
    public void insert(SpaceEntity SpaceEntity) {
        mSpaceDao.insert(SpaceEntity);
    }

    @Override
    public void delete(SpaceEntity SpaceEntity) {
        mSpaceDao.delete(SpaceEntity);
    }

    @Override
    public void update(SpaceEntity SpaceEntity) {
        mSpaceDao.update(SpaceEntity);
    }
}

