package fr.afe.majordome.ui.shoppingList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.afe.majordome.R;
import fr.afe.majordome.entities.TaskEntity;
import fr.afe.majordome.ui.shoppingList.ShoppingListViewModel;

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingListAdapter.ShoppingViewHolder> {

    class ShoppingViewHolder extends RecyclerView.ViewHolder {
        private final TextView taskItemView;

        private ShoppingViewHolder(View itemView) {
            super(itemView);
            taskItemView = itemView.findViewById(R.id.shopping_item_name);
        }
    }

    private final LayoutInflater mInflater;
    private List<TaskEntity> mTasks; // Cached copy of spaces
    private final View.OnClickListener mOnClickListener = null;
    private Context mContext;
    private ShoppingListViewModel mShoppingListViewModel;

    ShoppingListAdapter(Context context, ShoppingListViewModel shoppingListViewModel) {
        mInflater = LayoutInflater.from(context);
        mContext = context;
        mShoppingListViewModel = shoppingListViewModel;
    }


    @NonNull
    @Override
    public fr.afe.majordome.ui.shoppingList.ShoppingListAdapter.ShoppingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.shopping_item_layout, parent, false); //recyclerview_item
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
        return new fr.afe.majordome.ui.shoppingList.ShoppingListAdapter.ShoppingViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull fr.afe.majordome.ui.shoppingList.ShoppingListAdapter.ShoppingViewHolder holder, int position) {
        if (mTasks != null) {
            TaskEntity current = mTasks.get(position);
            holder.taskItemView.setText(current.taskName);
        } else {
            // Covers the case of data not being ready yet.
            holder.taskItemView.setText("No Space");
        }
    }

    @Override
    public int getItemCount() {
        if (mTasks != null)
            return mTasks.size();
        else return 0;
    }

    void setTasks(List<TaskEntity> tasks){
        mTasks = tasks;
        notifyDataSetChanged();
    }

    public TaskEntity getTask(int row) {
        return mTasks.get(row);
    }

}