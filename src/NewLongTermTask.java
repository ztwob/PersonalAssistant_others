import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class NewLongTermTask extends NewTask{
    private LongTermTask ltTask;

    public LongTermTask getLtTask() {
        return ltTask;
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
        field_des.setColumns(10);
        panel_des.add(field_des);

        JPanel panel_date = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel_name.add(new JLabel("请输入任务截止日期："));
        JTextField field_date = new JTextField("请按照YYYY-MM-DD hh:mm:ss的格式填写");
        panel_name.add(field_date);

        JPanel panel_condition = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField field_conditiong = new JTextField("（显示您的状态）     ");
        panel_condition.add(field_conditiong);

        JPanel panel_list = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton button_list = new JButton("添加子任务");
        button_list.setActionCommand("CHILD");
        panel_list.add(button_list);

        JPanel panel_button = new JPanel();
        JButton re_button = new JButton("重置");
        re_button.setActionCommand("RE");
        JButton comp_button = new JButton("添加");
        comp_button.setActionCommand("COM");
        JButton button_chileList = new JButton("添加子任务列表");
        button_chileList.setActionCommand("CHILD");
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("RE")) {
                    field_date.setText("请按照YYYY-MM-DD hh:mm:ss的格式填写");
                    field_des.setText("");
                    field_name.setText("");
                    field_conditiong.setText("（显示您的状态）");
                }
                else if("CHILD".equals(e.getActionCommand())){
                    NewChildList childList = new NewChildList();
                    //子任务表
                }
                else if (e.getActionCommand().equals("COM")) {
                    if ("".equals(field_name.getText())) {
                        field_conditiong.setText("未命名");
                        return;
                    }
                    ltTask.setName(field_name.getText());
                    ltTask.setDescription(field_des.getText());
                    SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD hh:mm;ss");

                    try {
                        ltTask.setDate(dateFormat.parse(field_date.getText()));
                    } catch (ParseException e1) {
                        field_conditiong.setText("日期输入不正常");
                        e1.printStackTrace();
                    }
                    taskList.addTask(ltTask);
                }
            }
        };
        comp_button.addActionListener(listener);
        re_button.addActionListener(listener);
        panel_button.add(re_button);
        panel_button.add(comp_button);

        Box hbox = Box.createVerticalBox();
        hbox.add(new JLabel("创建长期任务"));
        hbox.add(panel_name);
        hbox.add(panel_des);
        hbox.add(panel_date);
        hbox.add(panel_list);
        hbox.add(panel_button);
        hbox.add(panel_condition);

        getFrame().setContentPane(hbox);
        getFrame().pack();
    }
}
