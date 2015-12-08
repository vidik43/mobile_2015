package com.example.prj_02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.io.Closeable;

/**
 * @author vidik43
 */
public class EditActivity extends Activity implements Closeable, View.OnClickListener {

    private long taskID;

    private EditText taskText;
    private Button createTaskButton;
    private Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.create_task);

        this.taskText = (EditText) this.findViewById(R.id.taskText);

        this.createTaskButton = (Button) this.findViewById(R.id.createTaskButton);
        this.createTaskButton.setOnClickListener(this);

        this.cancelButton = (Button) this.findViewById(R.id.cancelButton);
        this.cancelButton.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = this.getIntent();
        this.setTaskText(intent.getStringExtra(ExtraData.TASK_TEXT.NAME));
        this.taskID = intent.getLongExtra(ExtraData.TASK_ID.NAME, -1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.createTaskButton:
                TasksActivity tasksActivity = TasksActivity.getInstance();
                if (this.taskID >= 0) {
                    tasksActivity.editTask(this.taskID, this.getTaskText());
                } else {
                    tasksActivity.addTask(this.getTaskText());
                }
                break;
        }
        this.close();
    }

    private String getTaskText() {
        return this.taskText.getText().toString();
    }

    private void setTaskText(String text) {
        this.taskText.setText(text);
    }

    @Override
    public void close() {
        this.finish();
    }
}
