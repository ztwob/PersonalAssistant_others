import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;
    private String name;

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public TaskList(String name,int n){
        tasks = new ArrayList<Task>(n);//具体创建时需要初始化
        setName(name);
    }

    public void addTask(Task task){
        this.tasks.add(task);
    }
}
