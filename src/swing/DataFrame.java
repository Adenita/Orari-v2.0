package swing;

import java.awt.*;
import javax.swing.*;



public class DataFrame  {


    DataPanel buttonPanel;
    JFrame frame;

    public DataFrame() {
        initialise();
    }

    void initialise() {

        frame = new JFrame();
        frame.setTitle("Data");
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.white);
        frame.setLayout(new BorderLayout());

        buttonPanel = new DataPanel();
        // JScrollBar scroll = new JScrollBar();
        // scroll.add(buttonPanel);
        frame.add(buttonPanel, BorderLayout.CENTER);
      

        //frame.pack();
        frame.setVisible(true);
       // frame.setResizable(false);
        frame.setLocationRelativeTo(null);

    }


   

  
}
