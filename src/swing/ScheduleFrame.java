package swing;

import java.awt.*;
import javax.swing.*;

import geneticAlgorithm.Data;


public class ScheduleFrame extends JFrame {
    
    public ScheduleFrame() {
        initialise();
    }

    void initialise() {
        SchedulePanel panel = new SchedulePanel(new Data());

        this.setTitle("Orari");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.white);
        this.setVisible(true);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        Thread th = new Thread() {
            @Override
            public void run() {
                while(panel.pop.getSchedules().get(0).getFitness() != 1)
                {
                    panel.evolveTables();
                    try {
                        Thread.sleep(400);
                    }catch(Exception e) {

                    }
                    
                }   
            };
        };

        th.start();
    }
}
