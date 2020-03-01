package fr.afe.majordome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import fr.afe.majordome.entities.SpaceEntity;
import fr.afe.majordome.entities.TaskEntity;
import fr.afe.majordome.ui.spaces.SpacesListAdapter;
import fr.afe.majordome.ui.spaces.SpacesViewModel;

import static fr.afe.majordome.ui.spaces.SpacesFragment.NEW_WORD_ACTIVITY_REQUEST_CODE;

public class SpaceActivity extends AppCompatActivity {
    private RecyclerView tasksRecyclerView;
    private TasksViewModel tasksViewModel;
    protected SpaceEntity spaceEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_space);
        TextView mTextView = findViewById(R.id.titleSpace);

        Intent intent = getIntent();
        spaceEntity = (SpaceEntity) intent.getSerializableExtra("SPACE");
        if (spaceEntity != null) {
            mTextView.setText(spaceEntity.spaceName);
        }

        // Handle Tasks
        tasksRecyclerView = findViewById(R.id.tasksRecyclerView);
        final TasksListAdapter adapter = new TasksListAdapter(this);
        tasksRecyclerView.setAdapter(adapter);
        tasksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //configureOnClickRecyclerView();

        // Get a new or existing ViewModel from the ViewModelProvider.
        tasksViewModel = ViewModelProviders.of(this).get(TasksViewModel.class);
        tasksViewModel.getTasksBySpaceId(spaceEntity.spaceId).observe(this, new Observer<List<TaskEntity>>() {
            @Override
            public void onChanged(List<TaskEntity> taskEntities) {
                // Update the cached copy of the words in the adapter.
                adapter.setTasks(taskEntities);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fabAddTask);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SpaceActivity.this, NewSpaceActivity.class);
                startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            TaskEntity taskEntity = new TaskEntity();
            taskEntity.referentTaskKind = spaceEntity.spaceId;
            taskEntity.taskName = data.getStringExtra(NewSpaceActivity.EXTRA_REPLY);
            tasksViewModel.insert(taskEntity);
            Log.d("DEBUG", "spaceId for task = " + spaceEntity.spaceId);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }
}
