import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.ArrayList;


public class MainPanel extends JPanel 
{
    Graphics graphics;
    Image image;
    private Data data;
    private int classNum = 1;
    private int counth = 0;
    private int countw = 0;



    public MainPanel ()
    {
        this.setPreferredSize(new Dimension(1000, 700));
        this.setFocusable(true); 
  
    }

    // public void paint(Graphics g) 
    // {
	// 	image = createImage(getWidth(), getHeight());
	// 	graphics = image.getGraphics();
	// 	draw(graphics);
	// 	g.drawImage(image, 0, 0, this); 
	// }

     public void paintComponent(Graphics gr, Schedule schedule, int generation){
        super.paintComponent(gr); 

        ArrayList<Event> events = schedule.getEvents();
        String[][] sEvents = new String[events.size()][];


        gr.drawString("Hello", 100, 0);
       

        events.forEach(x -> {
            int majorIndex = data.getPrograms().indexOf(x.getSubject().getProgram());
            int subjectIndex = data.getSubjects().indexOf(x.getSubject());
            int roomIndex = data.getAllClassrooms().indexOf(x.getClassroom());
            int professorIndex = data.getProfessors().indexOf(x.getProfessor());
            int lectureTimeIndex = data.getLectureTimes().indexOf(x.getLectureTime());
            int studentsGroupIndex = data.getAllStudentsGroups().indexOf(x.getGroup());
            gr.drawString("         ", 0, 10);
            gr.drawString(((String.format(" %1$02d", classNum) + "   | ") + " "), countw, 10 + counth);
            gr.drawString(((String.format("%1$4s", data.getPrograms().get(majorIndex).getName()) + " | ") + " "), countw, counth);
            gr.drawString((String.format("%1$40s", data.getSubjects().get(subjectIndex).getName() + " (" + data.getSubjects().get(subjectIndex).getStat() + ")    | ") + " "), countw, counth);
            gr.drawString(((String.format("%1$12s", data.getAllClassrooms().get(roomIndex).getName() + " (" + x.getClassroom().getNumberOfSeats()) + ") | ") + " "), countw, counth);
            gr.drawString(((String.format("%1$10s", data.getAllStudentsGroups().get(studentsGroupIndex).getName() + " (" + data.getAllStudentsGroups().get(studentsGroupIndex).getNumberOfStudents()) + ")  |  ") + " "), countw, counth);
            gr.drawString(((String.format("%1$18s", data.getProfessors().get(professorIndex).getName() + " |  ")) + " "), countw, counth);
            gr.drawString((data.getLectureTimes().get(lectureTimeIndex).getDay() + " " + data.getLectureTimes().get(lectureTimeIndex). getTime()+ " "), countw, counth);
            classNum++;
            counth += 10;
            countw += 20;

        });

    }

}