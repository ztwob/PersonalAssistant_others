import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewTypeTask {
    private JFrame frame_choose = new JFrame();

    public JFrame getFrame_choose() {
        return frame_choose;
    }

    public void newChooseWin(TaskList taskList){
        JButton button_freshen = new JButton("刷新");
        button_freshen.setActionCommand("FRE");
        JButton button_temp = new JButton("临时");
        button_temp.setActionCommand("TMP");
        JButton button_cycle = new JButton("周期");
        button_cycle.setActionCommand("CYC");
        JButton button_long = new JButton("长期");
        button_long.setActionCommand("LT");
        JButton button_comp = new JButton("返回");
        button_comp.setActionCommand("COM");

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if("TMP".equals(e.getActionCommand())){
                    NewTempTask tpTask = new NewTempTask();
                    tpTask.newWindow(taskList);
                    tpTask.getFrame().setVisible(true);
                }
                else if("CYC".equals(e.getActionCommand())){
                    NewCycleTask cyTask = new NewCycleTask();
                    cyTask.newWindow(taskList);
                    cyTask.getFrame().setVisible(true);
                }
                else if("LT".equals(e.getActionCommand())){
                    NewLongTermTask ltTask = new NewLongTermTask();
                    ltTask.newWindow(taskList);
                    ltTask.getFrame().setVisible(true);
                }
                else if("COM".equals(e.getActionCommand())){
                    frame_choose.dispose();
                }
                else if("FRE".equals(e.getActionCommand())){
                    //刷新
                }
            }
        };
        button_comp.addActionListener(listener);
        button_cycle.addActionListener(listener);
        button_freshen.addActionListener(listener);
        button_long.addActionListener(listener);
        button_temp.addActionListener(listener);

        FlowLayout layout = new FlowLayout();
        JPanel panel_to_look = new JPanel(layout);
        JPanel panel_button = new JPanel(layout);

        panel_to_look.add(new JTextArea(10,30));
        panel_button.add(button_freshen);
        panel_button.add(button_temp);
        panel_button.add(button_cycle);
        panel_button.add(button_long);
        panel_button.add(button_comp);

        JPanel panel_main = new JPanel();
        panel_main.add(panel_to_look);
        panel_main.add(panel_button);

        frame_choose.setContentPane(panel_main);
        frame_choose.pack();
    }
}
