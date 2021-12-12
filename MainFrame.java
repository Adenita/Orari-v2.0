import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame
{

    public MainFrame()
    {
        this.setTitle("Loja Pong");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(new Color(111,163,35));
        this.getContentPane().add(new MainPanel());
        this.pack(); 
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) 
    {
        new MainFrame();
    }
}

