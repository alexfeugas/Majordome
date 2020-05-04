package fr.afe.majordome.ui.stocks;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import fr.afe.majordome.ItemClickSupport;
import fr.afe.majordome.NewSpaceActivity;
import fr.afe.majordome.NewStockActivity;
import fr.afe.majordome.R;
import fr.afe.majordome.SpaceActivity;
import fr.afe.majordome.TaskActivity;
import fr.afe.majordome.entities.SpaceEntity;
import fr.afe.majordome.entities.StockEntity;
import fr.afe.majordome.entities.TaskEntity;
import fr.afe.majordome.ui.spaces.SpacesListAdapter;

import static android.app.Activity.RESULT_OK;
import static fr.afe.majordome.ui.spaces.SpacesFragment.NEW_WORD_ACTIVITY_REQUEST_CODE;

public class StocksFragment extends Fragment {
    public static final int NEW_STOCK_ACTIVITY_REQUEST_CODE = 1;
    private static final int DISPLAY_STOCK_ACTIVITY_REQUEST_CODE = 2;

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
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4));
        //recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        configureOnClickRecyclerView();


        FloatingActionButton fab = root.findViewById(R.id.fabStock);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), NewStockActivity.class);
                startActivityForResult(intent, NEW_STOCK_ACTIVITY_REQUEST_CODE);
            }
        });
        return root;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_STOCK_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            StockEntity stockEntity = (StockEntity) data.getSerializableExtra("EXTRA_REPLY");
            if (stockEntity != null) {
                stocksViewModel.insert(stockEntity);
            }
        } else if (requestCode == DISPLAY_STOCK_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            StockEntity stockEntity = (StockEntity) data.getSerializableExtra("EXTRA_REPLY");
            if (stockEntity != null) {
                stocksViewModel.update(stockEntity);
            }
        } else {
            Toast.makeText(
                    getContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }

    private void configureOnClickRecyclerView(){
        ItemClickSupport.addTo(recyclerView, R.layout.fragment_spaces)
                .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        StocksListAdapter adapter = (StocksListAdapter) recyclerView.getAdapter();
                        Log.e("TAG", "Position : "+position + " " + adapter.getStock(position).stockName);
                        Intent intent = new Intent(getActivity(), NewStockActivity.class);
                        intent.putExtra("STOCK", adapter.getStock(position));
                        startActivityForResult(intent, DISPLAY_STOCK_ACTIVITY_REQUEST_CODE);
                    }
                });
    }
}