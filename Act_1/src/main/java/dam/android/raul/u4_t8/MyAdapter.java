package dam.android.raul.u4_t8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


import dam.android.raul.u4_t8.model.Task;
import dam.android.raul.u4_t8.data.TodoListDBManager;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private TodoListDBManager todoListDBManager;
    private ArrayList<Task> myTaskList;

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvId;
        TextView tvTodo;
        TextView tvToAccomplish;
        TextView tvDescription;
        TextView tvStatus;
        TextView tvPriority;

        public MyViewHolder(View view) {
            super(view);

            this.tvId = view.findViewById(R.id.tvId);
            this.tvTodo = view.findViewById(R.id.tvTodo);
            this.tvToAccomplish = view.findViewById(R.id.tvToAccomplish);
            this.tvDescription = view.findViewById(R.id.tvDescription);
            this.tvStatus = view.findViewById(R.id.tvStatus);
            this.tvPriority = view.findViewById(R.id.tvPriority);
        }

        public void bind(Task task) {
            this.tvId.setText(String.valueOf(task.get_id()));
            this.tvTodo.setText(task.getTodo());
            this.tvToAccomplish.setText(task.getToAccomplish());
            this.tvDescription.setText(task.getDescription());
            int n_estatus = task.getStatus();
            int priority = task.getPriority();

            //TODO añadimos los switch
            String status = "";
            switch (n_estatus) {
                case 0:
                    status = "Not Started";
                    break;
                case 1:
                    status = "In Progress";
                    break;
                case 2:
                    status = "Completed";
                    break;
            }
            tvStatus.setText(status);

            String priorityy = "";
            switch (priority) {
                case 0:
                    priorityy = "Low";
                    break;
                case 1:
                    priorityy = "Normal";
                    break;
                case 2:
                    priorityy = "High";
                    break;
            }
            tvPriority.setText(priorityy);
        }
    }

    public MyAdapter(TodoListDBManager todoListDBManager) {
        this.todoListDBManager = todoListDBManager;
    }

    public void getData() {
        this.myTaskList = todoListDBManager.getTasks();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MyViewHolder(itemLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(myTaskList.get(position));
    }

    @Override
    public int getItemCount() {
        return myTaskList.size();
    }
}
