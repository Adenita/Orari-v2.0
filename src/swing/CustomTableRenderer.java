package swing;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import geneticAlgorithm.Collision;
import geneticAlgorithm.Schedule;

import java.awt.*;

//Custom DefaultTableCellRenderer
public class CustomTableRenderer extends DefaultTableCellRenderer {

    private Collision collision;
    private Schedule schedule;

    public CustomTableRenderer(Schedule schedule) {
        this.schedule = schedule;
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        collision = new Collision(schedule.getCollisionTable());
    
        if (collision.getCollisionTable()[row][column] == true) {
            component.setForeground(Color.RED);
            component.setFont(new Font("Times New Roman", Font.BOLD, 12));
        }
        else {
            component.setForeground(Color.black);
        }
        
        return component;
    }
}