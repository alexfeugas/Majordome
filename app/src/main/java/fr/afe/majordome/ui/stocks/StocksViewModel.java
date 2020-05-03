package fr.afe.majordome.ui.stocks;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import fr.afe.majordome.entities.MajordomeRepository;
import fr.afe.majordome.entities.StockEntity;
import fr.afe.majordome.entities.TaskEntity;

public class StocksViewModel extends AndroidViewModel {
    private MajordomeRepository repository;
    private LiveData<List<StockEntity>> mAllStocks;
    private LiveData<List<TaskEntity>> mTodayTasks;

    private MutableLiveData<String> mText;

    public StocksViewModel(@NonNull Application application) {
        super(application);
        repository = new MajordomeRepository(application);
        mText = new MutableLiveData<>();
        mText.setValue("This is Stocks fragment");

        mAllStocks = new MutableLiveData<>();
        mAllStocks = repository.getAllStocks();
        /*List<StockEntity> list = new ArrayList<>();
        StockEntity st1 = new StockEntity();
        st1.stockName = "Sample stock 1";
        StockEntity st2 = new StockEntity();
        st2.stockName = "Sample stock 2";
        StockEntity st3 = new StockEntity();
        st3.stockName = "Sample stock 3";
        list.add(st1);
        list.add(st2);
        list.add(st3);
        mAllStocks.setValue(list);*/
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<List<StockEntity>> getStocks() {
        return mAllStocks;
    }

    public void insert(StockEntity stock) {
        repository.insertStock(stock);
    }

    public void delete(StockEntity stock) {
        repository.deleteStock(stock);
    }

}