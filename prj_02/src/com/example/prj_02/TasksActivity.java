package com.example.prj_02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.*;

/**
 * @author vidik43
 */
public class TasksActivity extends Activity
        implements View.OnClickListener {

    private static TasksActivity instance;

    private final Object MUTEX = new Object();

    protected static final int REQUEST_ADD_TASK = 0;
    protected static final int REQUEST_EDIT_TASK = 1;

    protected static DBHelper dbHelper;
    protected static InteractiveArrayAdapter adapter;
    private ListView listView;

    private Button addTaskButton;

    private List<DBEntry> list;

    protected static TasksActivity getInstance() {
        return Objects.requireNonNull(instance);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main);

        this.addTaskButton = (Button) this.findViewById(R.id.addTaskButton);
        this.addTaskButton.setOnClickListener(this);

        this.listView = (ListView) this.findViewById(R.id.listView);
        dbHelper = new DBHelper(this);

        list = dbHelper.getAllEntries();

        adapter = new InteractiveArrayAdapter(this, this.list);
        this.listView.setAdapter(adapter);

        instance = this;

    }

    @Override
    protected void onResume() {
        this.updateList();
        super.onResume();
    }

    protected void openAddActivity() {
        Intent intent = new Intent(this, EditActivity.class);
        {
            intent.putExtra(ExtraData.TASK_TEXT.NAME, "");
            intent.putExtra(ExtraData.TASK_ID.NAME, -1);
        }
        this.startActivityForResult(intent, REQUEST_ADD_TASK);
    }

    protected void openEditActivity(DBEntry entry) {
        Intent intent = new Intent(this, EditActivity.class);
        {
            intent.putExtra(ExtraData.TASK_TEXT.NAME, entry.getText());
            intent.putExtra(ExtraData.TASK_ID.NAME, entry.getId());
            Toast.makeText(this, "" + entry.getId(), Toast.LENGTH_SHORT).show();
        }
        this.startActivityForResult(intent, REQUEST_EDIT_TASK);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addTaskButton:
                this.openAddActivity();
                break;
        }
    }

    protected void addTask(String taskText) {
        synchronized (this.MUTEX) {
            long rowID = dbHelper.addTask(taskText);
            this.list.add(0, new DBEntry(rowID, taskText, false));
        }
    }

    protected void editTask(long taskID, String taskText) {
        int id = this.list.size() - ((int) taskID);
        synchronized (this.MUTEX) {
            dbHelper.updateTask(taskID, taskText, false);

            DBEntry entry = this.list.remove(id);
            {
                entry.setText(taskText);
                entry.setSelected(false);
            }
            this.list.add(id, entry);
        }
    }

    protected void editTask(DBEntry entry) {
        synchronized (this.MUTEX) {
            dbHelper.updateTask(entry.getId(), entry.getText(), entry.isSelected());
        }
    }

    protected final void updateList() {
        synchronized (this.MUTEX) {
            adapter.notifyDataSetChanged();
        }
    }
}
