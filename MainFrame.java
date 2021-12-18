import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame
{

    public MainFrame()
    {
        this.setTitle("Orari");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.white);
        this.setVisible(true);
       // this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) 
    {
        MainFrame frame = new MainFrame();
        MainPanel panel = new MainPanel(new Data());
        
        frame.getContentPane().add(panel);
        frame.pack();
        Thread th = new Thread() {
            @Override
            public void run() {
                while(panel.pop.getSchedules().get(0).getFitness() != 1)
                {
                    panel.evolveTables();
                    try {
                        Thread.sleep(850);
                    }catch(Exception e) {

                    }
                   
                }   
            };
        };

        th.start();
    }
}

