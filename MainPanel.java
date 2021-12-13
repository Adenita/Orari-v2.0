import java.awt.Dimension;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

class MainPanel extends JPanel 
{
    public static final int populationSize = 100;
    public static final double mutationRate = 0.1;
    public static final double crossoverRate = 0.9;
    public static final int selectionSize = 3;
    public static final int eliteScedule = 1;   
    private int classNum = 1;

    private Data data;
    private int yp = 0;
    private DefaultTableCellRenderer cellRenderer;
    private JTable table;
    private JScrollPane scrollPane;
    Population pop;
    GeneticAlgorithm ga;


    public MainPanel(Data data) 
    {
        //Style panel
        setPreferredSize(new Dimension(1000, 580));
        setBackground(Color.white);
        setFocusable(true); 
        setLayout(new FlowLayout());
        
        int generation = 0;
        this.data = data;
        ga = new GeneticAlgorithm(data);
        pop = new Population(populationSize, data).sortByFitness();
        System.out.println("generate new population");
        
        getTables(pop, generation);
        styleTable(table);
        ++generation;

        scrollPane = new JScrollPane(table);
        add(scrollPane);
       

    }

    public void evolveTables() {

        remove(scrollPane);
        classNum = 1;
        pop = ga.evolve(pop).sortByFitness();
        System.out.println("evolve population");
        getTables(pop, 0);
        styleTable(table);
        scrollPane = new JScrollPane(table);
        add(scrollPane);
       
        revalidate();
        repaint();                    
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

        return string;
    }

    public String[] getTableHeader() {
        return new String[] {"Event #", " Program ","             Subject                 ","  ClassRoom   "," Student Group ","  Professor      ", "    Lecture time   "};
    }

}