package fr.afe.majordome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

import fr.afe.majordome.entities.TaskEntity;

public class TaskActivity extends AppCompatActivity {

    private TaskEntity taskEntity;
    private EditText taskNameEditText;
    private EditText taskDescriptionEditText;
    private NumberPicker taskDurationNumberPicker;
    private NumberPicker taskUnitNumberPicker;
    private RecyclerView taskExecutionRecyclerView;
    private Button okButton;
    private String[] unitVals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        unitVals = new String[] {"Jour(s)", "Semaine(s)", "Mois", "An(s)"};

        taskNameEditText = findViewById(R.id.taskNameEditText);
        taskDescriptionEditText = findViewById(R.id.taskDescriptionEditText);
        taskDurationNumberPicker = findViewById(R.id.taskDurationPicker);
        taskDurationNumberPicker.setMaxValue(50);
        taskDurationNumberPicker.setMinValue(1);

        taskUnitNumberPicker = findViewById(R.id.taskUnitPicker);
        taskUnitNumberPicker.setMaxValue(3);
        taskUnitNumberPicker.setMinValue(0);
        taskUnitNumberPicker.setDisplayedValues(unitVals);

        taskExecutionRecyclerView = findViewById(R.id.taskExecutionRecyclerView);
        okButton = findViewById(R.id.buttonOKTask);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Control data

                // Collect data and create entity
                if (taskEntity == null)
                    taskEntity = new TaskEntity();
                taskEntity.taskName = taskNameEditText.getText().toString();
                taskEntity.taskDescription = taskDescriptionEditText.getText().toString();
                taskEntity.taskPeriodicity = 0;
                int duration = taskDurationNumberPicker.getValue();
                int unit = taskUnitNumberPicker.getValue();
                if (unit == 0) {
                    unit = 1;
                } else if (unit == 1) {
                    unit = 7;
                } else if (unit == 2) {
                    unit = 30;
                } else if (unit == 3) {
                    unit = 365;
                }
                duration =duration * unit;
                taskEntity.taskPeriodicity = duration;

                // return it.
                Intent replyIntent = new Intent();
                replyIntent.putExtra("EXTRA_REPLY", taskEntity);
                setResult(RESULT_OK, replyIntent);
                finish();
            }
        });
        // Displaying an existing one ?
        Intent intent = getIntent();
        taskEntity = (TaskEntity) intent.getSerializableExtra("TASK");
        if (taskEntity != null) {
            taskNameEditText.setText(taskEntity.taskName);
            taskDescriptionEditText.setText(taskEntity.taskDescription);
        }
    }
}
