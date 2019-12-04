import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.text.DefaultEditorKit;

class SimRoadFrame extends JFrame {


    public SimRoadFrame() {

        JFrame f = new JFrame("Road Simulator");

        JTextField ArrivalRateText = new JTextField();
        JTextField SlowdonwRateText = new JTextField();
        JTextField CunInRateText = new JTextField();

        JPanel ArrivalRate = new JPanel();
        ArrivalRate.setLayout(new BoxLayout(ArrivalRate, BoxLayout.X_AXIS));
        ArrivalRate.add(new JLabel("ArrivalRate(%)"));
        ArrivalRate.add(ArrivalRateText);


        JPanel SlowdonwRate = new JPanel();
        SlowdonwRate.setLayout(new BoxLayout(SlowdonwRate, BoxLayout.X_AXIS));
        SlowdonwRate.add(new JLabel("SlowdonwRate(%)"));

        SlowdonwRate.add(SlowdonwRateText);

        JPanel CunInRate = new JPanel();
        CunInRate.setLayout(new BoxLayout(CunInRate, BoxLayout.X_AXIS));
        CunInRate.add(new JLabel("CunInRate(%)"));
        CunInRate.add(CunInRateText);

        JPanel Options = new JPanel();
        Options.setLayout(new BoxLayout(Options, BoxLayout.Y_AXIS));

        JPanel RunReset = new JPanel();
        RunReset.add(new JButton("Run"));
        RunReset.add(new JButton("Reset"));


        JButton ResetButton = new JButton("Reset");
        JButton RunButton = new JButton("Run");

        JPanel data1 = new JPanel();
        data1.setLayout(new BoxLayout(data1, BoxLayout.Y_AXIS));
        data1.add(new JLabel("Time"));
        data1.add(new JLabel("Cars"));

        JPanel data2 = new JPanel();
        data2.setLayout(new BoxLayout(data2, BoxLayout.Y_AXIS));
        data2.add(new JLabel("TripTime"));
        data2.add(new JLabel("Avg Speed"));




        Options.add(ArrivalRate);
        Options.add(SlowdonwRate);
        Options.add(CunInRate);
        add(RunReset, BorderLayout.WEST);
        add(Options, BorderLayout.CENTER);


        ResetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == ResetButton) {

                }
            }
        });

        RunButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == RunButton) {
                    SimRoad Sim = new SimRoad();
                }
            }
        });

    }
}