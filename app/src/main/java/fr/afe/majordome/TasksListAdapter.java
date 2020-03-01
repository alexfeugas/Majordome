package fr.afe.majordome;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.afe.majordome.entities.SpaceEntity;
import fr.afe.majordome.entities.TaskEntity;
import fr.afe.majordome.ui.spaces.SpacesListAdapter;

public class TasksListAdapter extends RecyclerView.Adapter<TasksListAdapter.TaskViewHolder>  {

    class TaskViewHolder extends RecyclerView.ViewHolder {
        private final TextView taskItemView;

        private TaskViewHolder(View itemView) {
            super(itemView);
            taskItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater mInflater;
    private List<TaskEntity> mTasks;

    TasksListAdapter(Context context) { mInflater = LayoutInflater.from(context); }


    @NonNull
    @Override
    public TasksListAdapter.TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new TasksListAdapter.TaskViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TasksListAdapter.TaskViewHolder holder, int position) {
        if (mTasks != null) {
            TaskEntity current = mTasks.get(position);
            holder.taskItemView.setText(current.taskName);
        } else {
            // Covers the case of data not being ready yet.
            holder.taskItemView.setText("No Task");
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
