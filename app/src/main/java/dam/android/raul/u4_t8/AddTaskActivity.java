package dam.android.raul.u4_t8;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import dam.android.raul.u4_t8.data.TodoListDBManager;

public class AddTaskActivity extends AppCompatActivity
{
    private EditText etTodo;
    private EditText etToAccomplish;
    private EditText etDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        setUI();
    }

    private void setUI()
    {
        etTodo = findViewById(R.id.etTodo);
        etToAccomplish = findViewById(R.id.etToAccomplish);
        etDescription = findViewById(R.id.etDescription);
    }

    public void onClick(View view)
    {
        if(view.getId() == R.id.buttonOk)
        {
            if(etTodo.getText().toString().length()>0)
            {
                TodoListDBManager todoListDBManager = new TodoListDBManager(this);

                todoListDBManager.inset(etTodo.getText().toString(),etToAccomplish.getText().toString(),etDescription.getText().toString());
            }else
                Toast.makeText(this,getResources().getText(R.string.task_data_empty),Toast.LENGTH_LONG).show();

            finish();
        }
    }
}
