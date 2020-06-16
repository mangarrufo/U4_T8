package dam.android.raul.u4_t8.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class TodoListDBHelper extends SQLiteOpenHelper
{
    private static TodoListDBHelper instaceDBHelper;

    public static synchronized TodoListDBHelper getInstance(Context context)
    {
        if(instaceDBHelper == null)
            instaceDBHelper= new TodoListDBHelper(context.getApplicationContext());

        return instaceDBHelper;
    }

    public TodoListDBHelper(@Nullable Context context) {
        super(context,TodoListBDContract.DB_NAME,null,TodoListBDContract.BD_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TodoListBDContract.Tasks.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(TodoListBDContract.Tasks.DELETE_TABLE);
        onCreate(db);
    }
}
