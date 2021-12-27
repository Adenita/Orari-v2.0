package swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;


public class MainFrame
{
    JPanel buttonPanel;
    JButton viewData;
    JButton generateSchedule;
    JFrame frame;

    public MainFrame() throws IOException
    {
        initialise();
    }

    void initialise() throws IOException {
        frame = new JFrame();
        frame.setTitle("Main");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.white);
        frame.setLayout(new BorderLayout());

        JLabel label = new JLabel("  Computer Science Schedule  ", SwingConstants.CENTER);
        label.setFont(new Font("Georgia", Font.BOLD, 25 ));
        label.setBackground(Color.gray);

        BufferedImage myPicture = ImageIO.read(new File("src/swing/logo.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        
        
        frame.add(label, BorderLayout.NORTH);
        frame.add(picLabel, BorderLayout.CENTER);

        panel();

        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }

    void panel() {
        buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.black);
    
        generateSchedule = new JButton("Generate Schedule");
        generateSchedule.setPreferredSize(new Dimension(150, 30));
        generateSchedule.setFont(new Font("Georgia", Font.BOLD, 12 ));
        generateSchedule.setBackground(Color.white);
        generateSchedule.setFocusPainted(false);

        generateSchedule.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new ScheduleFrame();
            }
        });

        viewData = new JButton("View Data");
        viewData.setPreferredSize(new Dimension(150, 30));
        viewData.setFont(new Font("Georgia", Font.BOLD, 12 ));
        viewData.setBackground(Color.white);
        viewData.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new DataFrame();
            }
        });
       
        buttonPanel.add(generateSchedule);
        buttonPanel.add(viewData);
    }
    
    
   



}

