package dam.android.raul.u4_t8;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import dam.android.raul.u4_t8.data.TodoListDBManager;

public class AddTaskActivity extends AppCompatActivity {
    private EditText etTodo;
    private EditText etToAccomplish;
    private EditText etDescription;
    private Spinner spinnerPriority;
    private Spinner spinnerStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        setUI();
    }

    //TODO añadimos los spinners
    private void setUI() {
        etTodo = findViewById(R.id.etTodo);
        etToAccomplish = findViewById(R.id.etToAccomplish);
        etDescription = findViewById(R.id.etDescription);
        spinnerPriority = findViewById(R.id.spinnerPriority);
        spinnerStatus = findViewById(R.id.spinnerStatus);

        ArrayAdapter<CharSequence> spinnerPriorityA = ArrayAdapter.createFromResource(this, R.array.priority, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> spinnerStatusA = ArrayAdapter.createFromResource(this, R.array.process, android.R.layout.simple_spinner_item);

        spinnerPriorityA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerStatusA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerPriority.setAdapter(spinnerPriorityA);
        spinnerStatus.setAdapter(spinnerStatusA);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.buttonOk) {
            if (etTodo.getText().toString().length() > 0) {
                TodoListDBManager todoListDBManager = new TodoListDBManager(this);

                todoListDBManager.inset(etTodo.getText().toString(), etToAccomplish.getText().toString(), etDescription.getText().toString(), spinnerPriority.getSelectedItemPosition(), spinnerStatus.getSelectedItemPosition());
            } else
                Toast.makeText(this, getResources().getText(R.string.task_data_empty), Toast.LENGTH_LONG).show();

            finish();
        }
    }
}
