package fr.afe.majordome.ui.stocks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.afe.majordome.R;
import fr.afe.majordome.entities.StockEntity;

public class StocksFragment extends Fragment {

    private StocksViewModel stocksViewModel;
    private RecyclerView recyclerView;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        stocksViewModel =
                ViewModelProviders.of(this).get(StocksViewModel.class);
        View root = inflater.inflate(R.layout.fragment_stocks, container, false);
        final TextView textView = root.findViewById(R.id.text_tools);
        stocksViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });


        recyclerView = root.findViewById(R.id.recycler_view_stocks);

        final StocksListAdapter adapter = new StocksListAdapter(getContext(), stocksViewModel);

        stocksViewModel.getStocks().observe(this, new Observer<List<StockEntity>>() {
            @Override
            public void onChanged(List<StockEntity> stockEntities) {
                // Update the cached copy of the words in the adapter.
                adapter.setStocks(stockEntities);
            }
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        return root;
    }
}