package dam.android.raul.u4_t8.model;

public class Task
{
    private int _id;
    private String todo;
    private String toAccmplish;
    private String description;

    public Task(int _id, String todo, String toAccmplish, String description)
    {
        this._id = _id;
        this.todo = todo;
        this.toAccmplish = toAccmplish;
        this.description = description;
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

    public String getToAccmplish() {
        return toAccmplish;
    }

    public void setToAccmplish(String toAccmplish) {
        this.toAccmplish = toAccmplish;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task{" +
                "_id=" + _id +
                ", todo='" + todo + '\'' +
                ", toAccmplish='" + toAccmplish + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
