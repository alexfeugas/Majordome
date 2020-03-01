package fr.afe.majordome.entities;

import androidx.lifecycle.LiveData;

import java.util.List;

public interface UserDatasource {

    LiveData<List<UserEntity>> getAll();
    void insert(UserEntity userEntity);
    void delete(UserEntity userEntity);
    void update(UserEntity userEntity);
}
