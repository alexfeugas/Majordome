package fr.afe.majordome.entities;

import androidx.lifecycle.LiveData;

import java.util.List;

public class LocalUserDatasource implements UserDatasource {

    private final UserDAO mUserDao;

    public LocalUserDatasource(UserDAO userDAO) {
        this.mUserDao = userDAO;
    }


    @Override
    public LiveData<List<UserEntity>> getAll() {
        return mUserDao.getAll();
    }

    @Override
    public void insert(UserEntity userEntity) {
        mUserDao.insert(userEntity);
    }

    @Override
    public void delete(UserEntity userEntity) {
        mUserDao.delete(userEntity);
    }

    @Override
    public void update(UserEntity userEntity) {
        mUserDao.update(userEntity);
    }
}
