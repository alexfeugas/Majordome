package fr.afe.majordome.ui.spaces;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import fr.afe.majordome.entities.MajordomeRepository;
import fr.afe.majordome.entities.SpaceEntity;

public class SpacesViewModel extends AndroidViewModel{

    private MajordomeRepository repository;
    private LiveData<List<SpaceEntity>> mAllSpaces;

    public SpacesViewModel(@NonNull Application application) {
        super(application);
        repository = new MajordomeRepository(application);
        mAllSpaces = repository.getAllSpaces();
    }

    public LiveData<List<SpaceEntity>> getAllSpaces() {
        return mAllSpaces;
    }

    public void insert(SpaceEntity space) {
        repository.insertSpace(space);
    }
}