import java.util.Date;

public class LongTermTask extends Task {
    private TaskList list;
    public LongTermTask(String name, String description, Date ddl,TaskList newList){
        setType(3);
        setName(name);
        setDescription(description);
        setDate(ddl);
        setList(newList);
        setFinished(false);
    }

    public TaskList getList() {
        return list;
    }

    public void setList(TaskList list) {
        this.list = list;
    }
}
