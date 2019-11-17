import java.util.Date;

public class WindowController {
    static protected MainWindow mainWindow;
    static public void newWindows(){
        TaskList taskList = new TaskList("",1);

        mainWindow = new MainWindow();

        mainWindow.newWindow(taskList);

        mainWindow.getMainFrame().setVisible(true);
    }
}
