package fr.afe.majordome.ui.shoppingList;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import fr.afe.majordome.entities.MajordomeRepository;
import fr.afe.majordome.entities.TaskEntity;

public class ShoppingListViewModel extends ViewModel {

    private MajordomeRepository repository;
    private MutableLiveData<List<TaskEntity>> mAllTasks;
    private LiveData<List<TaskEntity>> mTodayTasks;

    private MutableLiveData<String> mText;

    public ShoppingListViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Liste des achats à faire");

        mAllTasks = new MutableLiveData<>();
        List<TaskEntity> list = new ArrayList<>();
        TaskEntity st1 = new TaskEntity();
        st1.taskName = "Sample task 1";
        TaskEntity st2 = new TaskEntity();
        st2.taskName = "Sample task 2";
        TaskEntity st3 = new TaskEntity();
        st3.taskName = "Sample task 3";
        list.add(st1);
        list.add(st2);
        list.add(st3);
        mAllTasks.setValue(list);
    }

    public LiveData<String> getText() {
        return mText;
    }
    public LiveData<List<TaskEntity>> getTasks() {
        return mAllTasks;
    } // FIXME



}