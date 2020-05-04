package fr.afe.majordome.ui.stocks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.afe.majordome.R;
import fr.afe.majordome.entities.StockEntity;
import fr.afe.majordome.entities.TaskEntity;
import fr.afe.majordome.ui.today.TodayViewModel;

public class StocksListAdapter extends RecyclerView.Adapter<fr.afe.majordome.ui.stocks.StocksListAdapter.StockViewHolder> {


    public class StockViewHolder extends RecyclerView.ViewHolder {
        private final TextView stockItemView;
        private final TextView stockQuantityItemView;
        public StockViewHolder(@NonNull View itemView) {
            super(itemView);
            stockItemView = itemView.findViewById(R.id.stock_item_name);
            stockQuantityItemView = itemView.findViewById(R.id.stock_current_quantity);
        }
    }

    private final LayoutInflater mInflater;
    private List<StockEntity> mStocks; // Cached copy of spaces
    private final View.OnClickListener mOnClickListener = null;
    private Context mContext;
    private StocksViewModel mStockViewModel;

    public StocksListAdapter(Context context, StocksViewModel stocksViewModel) {
        mInflater = LayoutInflater.from(context);
        mContext = context;
        mStockViewModel = stocksViewModel;
    }


    @NonNull
    @Override
    public StockViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.stock_item_layout, parent, false);
       /* View button = itemView.findViewById(R.id.imageButtonDelete);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int itemPosition = ((RecyclerView)parent).getChildLayoutPosition((View)view.getParent());
                SpaceEntity current = mSpaces.get(itemPosition);
                //Toast.makeText(mContext, current.spaceId+ " " +current.spaceName, Toast.LENGTH_LONG).show();
                //FIXME: ask for confirmation
                mSpacesViewModel.delete(current);
            }
        });*/
        return new fr.afe.majordome.ui.stocks.StocksListAdapter.StockViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StockViewHolder holder, int position) {
        if (mStocks != null) {
            StockEntity current = mStocks.get(position);
            holder.stockItemView.setText(current.stockName);
            holder.stockQuantityItemView.setText("" + current.quantity);
        } else {
            // Covers the case of data not being ready yet.
            holder.stockItemView.setText("No stock yet");
        }
    }



    @Override
    public int getItemCount() {
        return mStocks != null ? mStocks.size() : 0 ;
    }


    public void setStocks(List<StockEntity> stockEntities) {
        mStocks = stockEntities;
        notifyDataSetChanged();
    }

    public StockEntity getStock(int row) {
        return mStocks.get(row);
    }

}
