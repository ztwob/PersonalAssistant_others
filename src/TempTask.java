import java.util.Date;

public class TempTask extends Task {
    public TempTask(String name, String description, Date ddl){
        setType(1);
        setName(name);
        setDescription(description);
        setDate(ddl);
        setFinished(false);
    }
}
