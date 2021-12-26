package swing;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import geneticAlgorithm.*;


public class SchedulePanel extends JPanel 
{
    public static final int populationSize = 100;
    public static final double mutationRate = 0.1;
    public static final double crossoverRate = 0.9;
    public static final int selectionSize = 3;
    public static final int eliteScedule = 1;   
    private int classNum = 1;

    private Data data;
    private int yp = 0;
    private CustomTableRenderer tableRenderer;
    private JTable table;
    private JScrollPane scrollPane;
    public Population pop;
    GeneticAlgorithm ga;


    public SchedulePanel(Data data) 
    {
        this.data = data;
        setPanel();
        
        int generation = 0;
        ga = new GeneticAlgorithm(data);
        pop = new Population(populationSize, data).sortByFitness();

        getTables(pop, generation);
        styleTable(table);
        ++generation;

        scrollPane = new JScrollPane(table);
        add(scrollPane);
       

    }

    // Style panel
    public void setPanel(){
        this.setPreferredSize(new Dimension(1000, 580));
        this.setBackground(Color.white);
        this.setFocusable(true); 
        this.setLayout(new FlowLayout());
    }

    public void evolveTables() {

        remove(scrollPane);
        classNum = 1;
        pop = ga.evolve(pop).sortByFitness();
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

        tableRenderer = new CustomTableRenderer(pop.getSchedules().get(0));
        table.setDefaultRenderer(String.class, tableRenderer);

        tableRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.setFont(new Font("Georgia", Font.PLAIN, 12));

        for (int i = 0; i < 7; i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(tableRenderer);
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