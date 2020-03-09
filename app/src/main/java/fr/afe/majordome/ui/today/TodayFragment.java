package fr.afe.majordome.ui.today;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.afe.majordome.R;
import fr.afe.majordome.TasksViewModel;
import fr.afe.majordome.entities.SpaceEntity;
import fr.afe.majordome.entities.TaskEntity;
import fr.afe.majordome.ui.spaces.SpacesListAdapter;
import fr.afe.majordome.ui.spaces.SpacesViewModel;

public class TodayFragment extends Fragment {

    private TodayViewModel todayViewModel;
    private RecyclerView recyclerView;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        todayViewModel =
                ViewModelProviders.of(this).get(TodayViewModel.class);
        View root = inflater.inflate(R.layout.fragment_today, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        todayViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        recyclerView = root.findViewById(R.id.recycler_view_home);

        // Get a new or existing ViewModel from the ViewModelProvider.
        todayViewModel = ViewModelProviders.of(this).get(TodayViewModel.class);
        final TodayListAdapter adapter = new TodayListAdapter(getContext(), todayViewModel);

        todayViewModel.getTasks().observe(this, new Observer<List<TaskEntity>>() {
            @Override
            public void onChanged(List<TaskEntity> taskEntities) {
                // Update the cached copy of the words in the adapter.
                adapter.setTasks(taskEntities);
            }
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return root;
    }
}