package fr.afe.majordome.ui.shoppingList;

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
import fr.afe.majordome.entities.TaskEntity;

public class ShoppingListFragment extends Fragment {

    private RecyclerView recyclerView;
    private ShoppingListViewModel todolistViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        todolistViewModel =
                ViewModelProviders.of(this).get(ShoppingListViewModel.class);

        View root = inflater.inflate(R.layout.fragment_courses, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        todolistViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        recyclerView = root.findViewById(R.id.recycler_view_shopping);
        // Get a new or existing ViewModel from the ViewModelProvider.
        todolistViewModel = ViewModelProviders.of(this).get(ShoppingListViewModel.class);
        final ShoppingListAdapter adapter = new ShoppingListAdapter(getContext(), todolistViewModel);

        todolistViewModel.getTasks().observe(this, new Observer<List<TaskEntity>>() {
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