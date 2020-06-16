package dam.android.raul.u4_t8.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import dam.android.raul.u4_t8.model.Task;

public class TodoListDBManager {
    private TodoListDBHelper todoListDBHelper;

    public TodoListDBManager(Context context) {
        todoListDBHelper = TodoListDBHelper.getInstance(context);
    }

    public void inset(String todo, String when, String description) {
        SQLiteDatabase sqLiteDatabase = todoListDBHelper.getWritableDatabase();

        if (sqLiteDatabase != null) {
            ContentValues contentValues = new ContentValues();

            contentValues.put(TodoListBDContract.Tasks.TODO, todo);
            contentValues.put(TodoListBDContract.Tasks.TO_ACCOMPLISH, when);
            contentValues.put(TodoListBDContract.Tasks.DESCRIPTION, description);

            sqLiteDatabase.insert(TodoListBDContract.Tasks.TABLE_NAME, null, contentValues);
        }
    }

    public ArrayList<Task> getTasks() {
        ArrayList<Task> tasksList = new ArrayList<>(1);

        SQLiteDatabase sqLiteDatabase = todoListDBHelper.getReadableDatabase();

        if (sqLiteDatabase != null) {
            String[] projection = new String[]{TodoListBDContract.Tasks._ID, TodoListBDContract.Tasks.TODO, TodoListBDContract.Tasks.TO_ACCOMPLISH, TodoListBDContract.Tasks.DESCRIPTION};

            Cursor cursorTodoList = sqLiteDatabase.query(TodoListBDContract.Tasks.TABLE_NAME, projection, null, null, null, null, null);

            if (cursorTodoList != null) {
                int _idIndex = cursorTodoList.getColumnIndexOrThrow(TodoListBDContract.Tasks._ID);
                int todoIndex = cursorTodoList.getColumnIndexOrThrow(TodoListBDContract.Tasks.TODO);
                int to_AccomplistIndex = cursorTodoList.getColumnIndexOrThrow(TodoListBDContract.Tasks.TO_ACCOMPLISH);
                int descriptionIndex = cursorTodoList.getColumnIndexOrThrow(TodoListBDContract.Tasks.DESCRIPTION);

                while (cursorTodoList.moveToNext()) {
                    Task task = new Task(
                            cursorTodoList.getInt(_idIndex),
                            cursorTodoList.getString(todoIndex),
                            cursorTodoList.getString(to_AccomplistIndex),
                            cursorTodoList.getString(descriptionIndex)
                    );

                    tasksList.add(task);
                }

                cursorTodoList.close();
            }
        }

        return tasksList;
    }

    public void close() {
        todoListDBHelper.close();
    }
}
