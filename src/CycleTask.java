import java.util.Date;

public class CycleTask extends Task {
    private int cycle;
    private int times;
    public CycleTask(String name, String description, Date startTime,int cycle,int times){
        setType(2);
        setName(name);
        setDescription(description);
        setDate(startTime);
        setCycle(cycle);
        setTimes(times);
        setFinished(false);
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public int getTimes() {
        return times;
    }

    public void setCycle(int cycle) {
        this.cycle = cycle;
    }

    public int getCycle() {
        return cycle;
    }
}
