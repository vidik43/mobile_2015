package com.example.prj_02;

import android.app.Activity;
import android.view.*;
import android.widget.*;

import java.util.List;

/**
 * @author vidik43
 */
public class InteractiveArrayAdapter extends ArrayAdapter<DBEntry> {

    private List<DBEntry> list;
    private Activity context;

    public InteractiveArrayAdapter(Activity context, List<DBEntry> list) {
        super(context, R.layout.checkbox_row, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {
            LayoutInflater inflater = this.context.getLayoutInflater();
            view = inflater.inflate(R.layout.checkbox_row, null);

            final ViewHolder viewHolder = new ViewHolder();
            viewHolder.textView = (TextView) view.findViewById(R.id.label);
            viewHolder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DBEntry entry = viewHolder.entry;
                    TasksActivity activity = (TasksActivity) InteractiveArrayAdapter.this.context;
                    activity.openEditActivity(entry);
                }
            });

            viewHolder.checkBox = (CheckBox) view.findViewById(R.id.checkBox);
            viewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DBEntry entry = viewHolder.entry;
                    entry.setSelected(viewHolder.checkBox.isChecked());
                    TasksActivity activity = (TasksActivity) InteractiveArrayAdapter.this.context;
                    activity.editTask(entry);
                }
            });
            view.setTag(viewHolder);
        } else {
            view = convertView;
        }
        ViewHolder vHolder = (ViewHolder) view.getTag();

        DBEntry entry = this.list.get(position);
        vHolder.checkBox.setChecked(entry.isSelected());
        vHolder.textView.setText(entry.getText());
        vHolder.entry = entry;

        return view;
    }

    private static class ViewHolder {
        protected TextView textView;
        protected CheckBox checkBox;
        protected DBEntry entry;
    }
}
