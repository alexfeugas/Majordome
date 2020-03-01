package fr.afe.majordome;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import fr.afe.majordome.entities.MajordomeRepository;
import fr.afe.majordome.entities.SpaceEntity;
import fr.afe.majordome.entities.TaskEntity;

public class TasksViewModel extends AndroidViewModel {
    private MajordomeRepository repository;
    private LiveData<List<TaskEntity>> mAllTasks;

    public TasksViewModel(@NonNull Application application) {
        super(application);
        repository = new MajordomeRepository(application);
        mAllTasks = repository.getAllTasks();
    }

    public LiveData<List<TaskEntity>> getAllTasks() {
        return mAllTasks;
    }
    public LiveData<List<TaskEntity>> getTasksBySpaceId(int spaceId) {
        return repository.getTasksBySpaceId(spaceId);
    }

    public void insert(TaskEntity task) {
        repository.insertTask(task);
    }
}
