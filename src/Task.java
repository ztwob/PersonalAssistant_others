import java.util.Date;
import java.util.Scanner;

public class Task {
    private int type;//1-临时，2-周期，3-长期
    // 需要设置相应的get set权限
    private String name;
    private String description;
    private Date date;
    private boolean isFinished;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public Task(){};
}
