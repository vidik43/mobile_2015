package com.example.prj_02;

import android.content.*;
import android.database.*;
import android.database.sqlite.*;
import android.provider.BaseColumns;
import android.util.Log;

import java.io.Closeable;
import java.util.*;

/**
 * @author vidik43
 */
public final class DBHelper extends SQLiteOpenHelper implements Closeable {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "tasks.db";

    private SQLiteDatabase db;

    public DBHelper(Context context) {
        this(context, DB_NAME, null, DB_VERSION, null);
    }

    public DBHelper(Context context, String name,
                    SQLiteDatabase.CursorFactory factory, int version) {
        this(context, name, factory, version, null);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                    int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
        this.db = this.getWritableDatabase();
    }

    public long addTask(String taskText) {
        ContentValues values = DBHelper.contentValues(taskText, false);
        return this.db.insert(TasksTable.TABLE_NAME, null, values);
    }

    public boolean updateTask(long taskID, String taskText, boolean done) {
        ContentValues values = DBHelper.contentValues(taskText, done);

        return this.db.update(TasksTable.TABLE_NAME, values,
                String.format("%s = %d", BaseColumns._ID, taskID), null) > 0;
    }

    public boolean deleteTask(long taskID) {
        return this.db.delete(TasksTable.TABLE_NAME,
                BaseColumns._ID.concat("=") + taskID, null) > 0;
    }

    private static ContentValues contentValues(String taskText, boolean done) {
        ContentValues values = new ContentValues();
        {
            values.put(TasksTable.COL_TASK, taskText);
            values.put(TasksTable.COL_DONE, done);
        }
        return values;
    }

    public Cursor getTasksCursor() {
        Cursor cursor = this.db.query(
                TasksTable.TABLE_NAME,
                null, null, null, null, null,
                BaseColumns._ID.concat(" DESC")
        );
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public Cursor getTasksCursor(long taskID) {
        Cursor cursor = this.db.query(
                TasksTable.TABLE_NAME,
                null, BaseColumns._ID.concat("=" + taskID),
                null, null, null,
                BaseColumns._ID.concat(" DESC")
        );
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public Cursor getTasksCursor(boolean done) {
        Cursor cursor = this.db.query(
                TasksTable.TABLE_NAME,
                null, String.format("%s = %d", TasksTable.COL_DONE, done ? 1 : 0),
                null, null, null,
                BaseColumns._ID.concat(" DESC")
        );
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public List<DBEntry> getAllEntries() {
        return entryList(this.getTasksCursor());
    }

    public List<DBEntry> getEntries(boolean done) {
        return entryList(this.getTasksCursor(done));
    }

    public List<DBEntry> getEntry(long taskID) {
        return entryList(this.getTasksCursor(taskID));
    }

    private static List<DBEntry> entryList(Cursor cursor) {
        int count = cursor.getCount();
        List<DBEntry> list = new LinkedList<>();

        if (count > 0) {
            long id;
            String taskText;
            int done;
            do {
                id = cursor.getLong(0);
                taskText = cursor.getString(1);
                done = cursor.getInt(2);
                list.add(new DBEntry(id, taskText, (done > 0)));
            } while (cursor.moveToNext());
        }

        return list;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TasksTable.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w("SQLite", "Update the database from version " + oldVersion + " to version " + newVersion);
        db.execSQL(TasksTable.DROP_TABLE);
        this.onCreate(db);
    }

    public static final class TasksTable {

        public static final String TABLE_NAME = "Tasks";

        public static final String COL_TASK = "task";
        public static final String COL_DONE = "done";

        protected static final String CREATE_TABLE = String.format(
                "CREATE TABLE %s " +
                        "(%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "%s TEXT NOT NULL, " +
                        "%s BOOLEAN);",
                TasksTable.TABLE_NAME,
                BaseColumns._ID,
                TasksTable.COL_TASK,
                TasksTable.COL_DONE
        );

        protected static final String DROP_TABLE = String.format(
                "DROP TABLE IF IT EXISTS %s;",
                TasksTable.TABLE_NAME
        );

        private TasksTable() {
        }
    }
}
