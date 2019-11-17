import javax.swing.*;

public class NewTask {
    private JFrame frame = new JFrame();

    public JFrame getFrame() {
        return frame;
    }
    public void windowVisible(){
        frame.setVisible(true);
    }

    public void windowNotVisible(){
        frame.setVisible(false);
    }
}
