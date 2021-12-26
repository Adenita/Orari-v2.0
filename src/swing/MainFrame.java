package swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class MainFrame
{
    JButton viewData;
    JButton generateSchedule;
    JFrame frame;

    public MainFrame()
    {
        initialise();
    }

    void initialise() {
        frame = new JFrame();
        frame.setTitle("Main");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.white);
        frame.setLayout(new FlowLayout());

        generateSchedule = new JButton("Generate Schedule");
        generateSchedule.setPreferredSize(new Dimension(150, 50));
        generateSchedule.setFont(new Font("Georgia", Font.BOLD, 12 ));


        generateSchedule.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new ScheduleFrame();
            }
        });

        viewData = new JButton("View Data");
        viewData.setPreferredSize(new Dimension(150, 50));
        viewData.setFont(new Font("Georgia", Font.BOLD, 12 ));
        viewData.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new DataFrame();
            }
        });

        frame.add(generateSchedule);
        frame.add(viewData);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }
}

