import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewCycleTask extends NewTask{
    private CycleTask cycleTask;
    public CycleTask getCycleTask() {
        return cycleTask;
    }

    public void newWindow(TaskList taskList){

        JPanel panel_name = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel_name.add(new JLabel("请输入任务名：   "));
        JTextField field_name = new JTextField();
        field_name.setColumns(10);
        panel_name.add(field_name);

        JPanel panel_des = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel_des.add(new JLabel("请输入任务描述："));
        JTextField field_des = new JTextField();
        field_des.setColumns(30);
        panel_des.add(field_des);

        JPanel panel_date = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel_name.add(new JLabel("请输入任务开始日期："));
        JTextField field_date = new JTextField("请按照YYYY-MM-DD hh:mm:ss的格式填写");
        panel_name.add(field_date);

        JPanel panel_cycle = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel_cycle.add(new JLabel("请输入任务周期： "));
        JTextField field_cycle = new JTextField();
        field_cycle.setColumns(10);
        panel_cycle.add(field_cycle);

        JPanel panel_times = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel_times.add(new JLabel("请输入进行次数："));
        JTextField field_times = new JTextField();
        field_times.setColumns(10);
        panel_times.add(field_times);

        JPanel panel_condition = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField field_conditiong = new JTextField("（显示您的状态）    ");
        panel_condition.add(field_conditiong);

        JPanel panel_button = new JPanel();
        JButton re_button = new JButton("重置");
        re_button.setActionCommand("RE");
        JButton comp_button = new JButton("添加");
        comp_button.setActionCommand("COM");
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("RE")) {
                    field_date.setText("请按照YYYY-MM-DD hh:mm:ss的格式填写");
                    field_des.setText("");
                    field_name.setText("");
                    field_cycle.setText("");
                    field_times.setText("");
                    field_conditiong.setText("（显示您的状态）    ");
                } else if (e.getActionCommand().equals("COM")) {
                    String cycleText = field_cycle.getText();
                    String timesText = field_times.getText();
                    if ("".equals(field_name.getText())) {
                        field_conditiong.setText("未命名");
                        return;
                    }
                    else if("".equals(cycleText)||"".equals(timesText)
                            ||Integer.parseInt(cycleText)<1
                            ||Integer.parseInt(timesText)<1){
                        field_conditiong.setText("次数或周期输入错误");
                        return;
                    }
                    cycleTask = new CycleTask("","",new Date(),-1,-1);
                    cycleTask.setName(field_name.getText());
                    cycleTask.setDescription(field_des.getText());
                    cycleTask.setTimes(Integer.parseInt(field_times.getText()));
                    cycleTask.setCycle(Integer.parseInt(field_cycle.getText()));
                    SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD hh:mm;ss");

                    try {
                        cycleTask.setDate(dateFormat.parse(field_date.getText()));
                    } catch (ParseException e1) {
                        e1.printStackTrace();
                    }

                    taskList.addTask(cycleTask);
                }
            }
        };
        comp_button.addActionListener(listener);
        re_button.addActionListener(listener);
        panel_button.add(re_button);
        panel_button.add(comp_button);

        Box hbox = Box.createVerticalBox();
        hbox.add(new JLabel("创建周期任务"));
        hbox.add(panel_name);
        hbox.add(panel_des);
        hbox.add(panel_date);
        hbox.add(panel_cycle);
        hbox.add(panel_times);
        hbox.add(panel_button);
        hbox.add(panel_condition);

        getFrame().setContentPane(hbox);
        getFrame().pack();
    }


}
