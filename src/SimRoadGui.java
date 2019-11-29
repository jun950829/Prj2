import java.awt.*;
import javax.swing.*;

public class SimRoadGui {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                 JFrame frame = new SimRoadFrame();
                frame.setTitle("SimRoad");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}





