package fr.afe.majordome.ui.stocks;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import fr.afe.majordome.entities.MajordomeRepository;
import fr.afe.majordome.entities.StockEntity;
import fr.afe.majordome.entities.TaskEntity;

public class StocksViewModel extends ViewModel {
    private MajordomeRepository repository;
    private MutableLiveData<List<StockEntity>> mAllStocks;
    private LiveData<List<TaskEntity>> mTodayTasks;

    private MutableLiveData<String> mText;

    public StocksViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Stocks fragment");

        mAllStocks = new MutableLiveData<>();
        List<StockEntity> list = new ArrayList<>();
        StockEntity st1 = new StockEntity();
        st1.stockName = "Sample stock 1";
        StockEntity st2 = new StockEntity();
        st2.stockName = "Sample stock 2";
        StockEntity st3 = new StockEntity();
        st3.stockName = "Sample stock 3";
        list.add(st1);
        list.add(st2);
        list.add(st3);
        mAllStocks.setValue(list);
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<List<StockEntity>> getStocks() {
        return mAllStocks;
    }
}