
import java.util.ArrayList;

public class Event 
{	
	private LectureTime lecture;	
    private Professor professor;
    private Subject subject;
    private Classroom classroom;
    private ArrayList<StudentsGroup> groups;
    private StudentsGroup group;
    private boolean isExercise; 
    private int id;
    private boolean conflicit;
    private static int count = 0;

    public Event(Subject subject){
        this.subject = subject;
        this.id = ++count;
    }

    public int getId() {
        return id;
    }

    public boolean getIsExercise() {
        return isExercise;
    }
	
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
    public void setLectureTime(LectureTime lecture) {
		this.lecture = lecture;
	}
	
    public Subject getSubject() {
		return subject;
	}

    public Classroom getClassroom() {
		return classroom;
	}
	
    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
	}
	
	
    public Professor getProfessor() {
		return professor;
	}
    
    public LectureTime getLectureTime() {
		return lecture;
	}

    public StudentsGroup getGroup() {
        return group;
    }

    public void setGroup(StudentsGroup studentsGroups) { 
        group = studentsGroups;
    }
    public ArrayList<StudentsGroup> getGroups() { 
        return groups; 
    }

    public void setGroup(ArrayList<StudentsGroup> groups) { 
        this.groups = groups;
    }

    public StudentsGroup getGroupa(String name) {
        for (int i = 0; i < groups.size(); i++) {
            if(groups.get(i).getName() == name)
                return groups.get(i);
        }

        return null;
    }
	
    public String toString() {
        return "[" + subject.getProgram().getName()+ "," + 
                subject.getName() + "," + classroom.getName()+ "," + professor.getID() + "]";
	}

    public void setConflict(boolean conflict) {
       this.conflicit = conflict;
    }    

    public boolean conflict() {
        return conflicit;
    }

}
