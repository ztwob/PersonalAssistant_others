import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow {
    private JFrame mainFrame = new JFrame();

    public void newWindow(TaskList taskList){
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel_new = new JPanel();
        JButton button_new = new JButton("新建");
        button_new.setActionCommand("NEW");

        JLabel label_new = new JLabel("新建任务");
        panel_new.add(button_new);
        panel_new.add(label_new);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if("NEW".equals(e.getActionCommand())){
                    NewTypeTask typeTask = new NewTypeTask();
                    typeTask.newChooseWin(taskList);
                    typeTask.getFrame_choose().setVisible(true);
                }
                else if("DEL".equals(e.getActionCommand())){
                    //查看列表下内容
                }
                else if("CHA".equals(e.getActionCommand())){
                    //改
                }
                else if("SORT".equals(e.getActionCommand())){
                    //排序
                }
            }
        };
        button_new.addActionListener(listener);
        Box box = Box.createVerticalBox();
        box.add(new JLabel("主界面"));
        box.add(new JTextArea(10,30));//显示主列表

        box.add(panel_new);

        mainFrame.setContentPane(box);
        mainFrame.pack();
    }

    public JFrame getMainFrame() {
        return mainFrame;
    }
}
