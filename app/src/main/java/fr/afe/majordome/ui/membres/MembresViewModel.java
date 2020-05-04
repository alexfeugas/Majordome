package fr.afe.majordome.ui.membres;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MembresViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MembresViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Membres du projet");
    }

    public LiveData<String> getText() {
        return mText;
    }
}