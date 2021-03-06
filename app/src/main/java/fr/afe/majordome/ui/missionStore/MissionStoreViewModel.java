package fr.afe.majordome.ui.missionStore;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MissionStoreViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MissionStoreViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Available Missions");
    }

    public LiveData<String> getText() {
        return mText;
    }
}