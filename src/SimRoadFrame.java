import java.awt.*;
import javax.swing.*;

class SimRoadFrame extends JFrame {


    public SimRoadFrame() {

        JPanel Northpanel = new JPanel();
        Northpanel.setLayout(new GridLayout(2, 4));

        JPanel southPanel = new JPanel();
        JButton ResetButton = new JButton("Reset");
        JButton RunButton = new JButton("Run");

        southPanel.add(ResetButton);
        southPanel.add(RunButton);

        add(southPanel);
        add(Northpanel);


    }
}