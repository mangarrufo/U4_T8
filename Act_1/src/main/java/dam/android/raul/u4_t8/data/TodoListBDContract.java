package dam.android.raul.u4_t8.data;

public class TodoListBDContract {
    public static final String DB_NAME = "TODOLIST.DB";
    public static final int BD_VERSION = 2;

    private TodoListBDContract() {

    }

    public static class Tasks {

        public static final String TABLE_NAME = "TASKS";

        public static final String _ID = "_id";
        public static final String TODO = "todo";
        public static final String TO_ACCOMPLISH = "to_accomplish";
        public static final String DESCRIPTION = "description";
        //todo agreagamos status y priority
        public static final String STATUS = "status";
        public static final String PRIORITY = "priority";

        public static final String CREATE_TABLE = "CREATE TABLE " + TodoListBDContract.Tasks.TABLE_NAME + " (" + TodoListBDContract.Tasks._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + TodoListBDContract.Tasks.TODO + " TEXT NOT NULL," + TodoListBDContract.Tasks.TO_ACCOMPLISH + " TEXT," + TodoListBDContract.Tasks.DESCRIPTION + " TEXT," + TodoListBDContract.Tasks.STATUS + " INTEGER," + Tasks.PRIORITY + " INTEGER);";

        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TodoListBDContract.Tasks.TABLE_NAME;
    }
}
