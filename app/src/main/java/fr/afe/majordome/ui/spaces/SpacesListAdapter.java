package fr.afe.majordome.ui.spaces;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.afe.majordome.R;
import fr.afe.majordome.entities.SpaceEntity;

public class SpacesListAdapter extends RecyclerView.Adapter<SpacesListAdapter.SpaceViewHolder> {

    class SpaceViewHolder extends RecyclerView.ViewHolder {
        private final TextView spaceItemView;

        private SpaceViewHolder(View itemView) {
            super(itemView);
            spaceItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater mInflater;
    private List<SpaceEntity> mSpaces; // Cached copy of spaces
    private final View.OnClickListener mOnClickListener = null;
    private Context mContext;
    private SpacesViewModel mSpacesViewModel;
    SpacesListAdapter(Context context, SpacesViewModel spacesViewModel) {
        mInflater = LayoutInflater.from(context);
        mContext = context;
        mSpacesViewModel = spacesViewModel;
    }


    @NonNull
    @Override
    public SpaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        View button = itemView.findViewById(R.id.imageButtonDelete);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int itemPosition = ((RecyclerView)parent).getChildLayoutPosition((View)view.getParent());
                SpaceEntity current = mSpaces.get(itemPosition);
                //Toast.makeText(mContext, current.spaceId+ " " +current.spaceName, Toast.LENGTH_LONG).show();
                //FIXME: ask for confirmation
                mSpacesViewModel.delete(current);
            }
        });
        return new SpaceViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SpaceViewHolder holder, int position) {
        if (mSpaces != null) {
            SpaceEntity current = mSpaces.get(position);
            holder.spaceItemView.setText(current.spaceName);
        } else {
            // Covers the case of data not being ready yet.
            holder.spaceItemView.setText("No Space");
        }
    }

    @Override
    public int getItemCount() {
        if (mSpaces != null)
            return mSpaces.size();
        else return 0;
    }

    void setSpaces(List<SpaceEntity> spaces){
        mSpaces = spaces;
        notifyDataSetChanged();
    }

    public SpaceEntity getSpace(int row) {
        return mSpaces.get(row);
    }


}