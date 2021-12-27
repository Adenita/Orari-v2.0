package swing;

import java.awt.*;
import javax.swing.*;

import geneticAlgorithm.Data;


public class ScheduleFrame  {
    
    private JFrame frame;
    public ScheduleFrame() {
        initialise();
    }

    void initialise() {
        frame = new JFrame();
        SchedulePanel panel = new SchedulePanel(new Data());

        frame.setTitle("Orari");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.white);
        frame.setVisible(true);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
      //  JLabel label = new JLabel("Generation: " + panel.generation);
        Thread th = new Thread() {
            @Override
            public void run() {
                while(panel.pop.getSchedules().get(0).getFitness() != 1)
                {
                   // frame.add(label, BorderLayout.NORTH);
                    panel.evolveTables();
                    try {
                        Thread.sleep(450);
                    }catch(Exception e) {

                    }
                    
                }   
            };
        };

        th.start();
    }
}
