package dam.android.raul.u4_t8.model;

public class Task {
    private int _id;
    private String todo;
    private String toAccomplish;
    private String description;
    //todo añadimos status y priority
    private int status;
    private int priority;

    public Task(int _id, String todo, String toAccomplish, String description, int status, int priority) {
        this._id = _id;
        this.todo = todo;
        this.toAccomplish = toAccomplish;
        this.description = description;
        this.status = status;
        this.priority = priority;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public String getToAccomplish() {
        return toAccomplish;
    }

    public void setToAccomplish(String toAccomplish) {
        this.toAccomplish = toAccomplish;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task{" +
                "_id=" + _id +
                ", todo='" + todo + '\'' +
                ", toAccomplish='" + toAccomplish + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", priority=" + priority +
                '}';
    }
}
