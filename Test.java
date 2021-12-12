import java.awt.*;
import java.util.ArrayList;
import java.awt.FlowLayout.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class Test extends JFrame
{
    public Test () {
        this.setTitle("Test");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.BLACK);
        this.getContentPane().add(new TestPanel());
        this.pack(); 
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }
    public static void main(String[] args) {
        new Test();     
    }

}

class TestPanel extends JPanel 
{
    JTable table;
    public static final int populationSize = 100;
    public static final double mutationRate = 0.1;
    public static final double crossoverRate = 0.9;
    public static final int selectionSize = 3;
    public static final int eliteScedule = 1;   
    private int classNum = 1;
    private Data data;
    private int yp = 0;
    private DefaultTableCellRenderer cellRenderer;
    private JScrollPane scrollPane;
    Image image;
    Graphics graphics;


    public TestPanel() 
    {
        setPreferredSize(new Dimension(1000, 550));
        setBackground(Color.pink);
        setFocusable(true); 
        setLayout(new FlowLayout());
        
        data = new Data();
        int generation = 0;
        GeneticAlgorithm ga = new GeneticAlgorithm(data);
        Population pop = new Population(Main.populationSize, data).sortByFitness();
        
        getTables(pop, generation);
        styleTable(table);
        ++generation;

        scrollPane = new JScrollPane(table);
        add(scrollPane);

        if (pop.getSchedules().get(0).getFitness() != 1)
        this.remove(scrollPane);

        evolveTables(ga, pop, generation);

        

        // Thread gameThread = new Thread((Runnable) this);
        // gameThread.start();
    }

    public void evolveTables(GeneticAlgorithm ga, Population pop, int generation) {
        while(pop.getSchedules().get(0).getFitness() != 1)
        {
            pop = ga.evolve(pop).sortByFitness();
            getTables(pop, generation);
            styleTable(table);
            classNum = 1;
            scrollPane = new JScrollPane(table);
            add(scrollPane);

        }
    }

    public void getTables(Population pop, int generation) {
        table = new JTable(getData(pop.getSchedules().get(0), generation), getTableHeader());
        table.setPreferredScrollableViewportSize(new Dimension(1000, 550));
        table.setFillsViewportHeight(true);
    }

    public void styleTable(JTable table) {
        
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        table.getColumnModel().getColumn(3).setPreferredWidth(150);
        table.getColumnModel().getColumn(4).setPreferredWidth(150);
        table.getColumnModel().getColumn(5).setPreferredWidth(150);
        table.getColumnModel().getColumn(6).setPreferredWidth(150);

        cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < 7; i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
    }

    // public void paint(Graphics g) 
    // {
	// 	image = createImage(getWidth(), getHeight());
	// 	graphics = image.getGraphics();
	// 	draw(graphics);
	// 	g.drawImage(image, 0, 0, this); 
    //     // super.paintComponent(g);
	// }

    public void draw(Graphics g, Schedule schedule) 
    {
       
             
 	}

    public String[][] getData(Schedule schedule, int generation) 
    {
        ArrayList<Event> events = schedule.getEvents();
        String[][] string = new String[events.size()][7];
        yp = 0;
        events.forEach(x -> {
            int majorIndex = data.getPrograms().indexOf(x.getSubject().getProgram());
            int subjectIndex = data.getSubjects().indexOf(x.getSubject());
            int roomIndex = data.getAllClassrooms().indexOf(x.getClassroom());
            int professorIndex = data.getProfessors().indexOf(x.getProfessor());
            int lectureTimeIndex = data.getLectureTimes().indexOf(x.getLectureTime());
            int studentsGroupIndex = data.getAllStudentsGroups().indexOf(x.getGroup());

            string[yp][0] = String.format(" %1$02d", classNum);
            string[yp][1] = String.format("%1$4s", data.getPrograms().get(majorIndex).getName());
            string[yp][2] = String.format("%1$4s", data.getSubjects().get(subjectIndex).getName() + " (" + data.getSubjects().get(subjectIndex).getStat() + ")" );
            string[yp][3] = String.format("%1$12s", data.getAllClassrooms().get(roomIndex).getName() + " (" + x.getClassroom().getNumberOfSeats() + ")");
            string[yp][4] = String.format("%1$10s", data.getAllStudentsGroups().get(studentsGroupIndex).getName() + " (" + data.getAllStudentsGroups().get(studentsGroupIndex).getNumberOfStudents() + ")");
            string[yp][5] = String.format("%1$4s", data.getProfessors().get(professorIndex).getName());
            string[yp][6] = data.getLectureTimes().get(lectureTimeIndex).getDay() + " " + data.getLectureTimes().get(lectureTimeIndex). getTime();
            classNum++;
            yp++;

        });

        // for (int i = 0; i < string.length; i++) {
        //     for (int j = 0; j < string[0].length; j++) {
        //         System.out.print(string[i][j]+ " ");
        //     }
        //     System.out.println();
        // }

        return string;
    }

    public String[] getTableHeader() {
        return new String[] {"Event #", " Program ","             Subject                 ","  ClassRoom   "," Student Group ","  Professor      ", "    Lecture time   "};
    }


}

 //Custom DefaultTableCellRenderer
 class CustomTableRenderer extends DefaultTableCellRenderer {
    public Component getTableCellRenderer(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        
        String versionVal = table.getValueAt(row, column).toString();

        // events.forEach(y -> { 
        //     if(y.getId() > x.getId()) { 
        //     if (x.getLectureTime().collision(y.getLectureTime())) {
        //         if (x.getClassroom().getClassID() == (y.getClassroom().getClassID())) {
        //          numberOfConflicts++;
        //          y.setConflict(true);
        //         }
        //         if (x.getProfessor().getID() ==  y.getProfessor().getID()) {
        //             numberOfConflicts++;
        //             y.setConflict(true);
        //         }   
        //     }
        //     }
        // });

        // if (table.getValueAt(row, column) == table.getValueAt(row, column)) {

        // }

        // if(versionVal.contains("FAKE")) {
        //     //set to red bold font
        //     c.setForeground(Color.RED);
        //     c.setFont(new Font("Dialog", Font.BOLD, 12));
        // } else {
        //     //stay at default
        //     c.setForeground(Color.BLACK);
        //     c.setFont(new Font("Dialog", Font.PLAIN, 12));
        // }
        return c;
    }

}