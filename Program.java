import java.util.ArrayList;

public class Program 
{
    private int programID = 111;
    private String name;
    private Department department;
    private static int count = 1000;

    private ArrayList<Subject> subjects;
    private ArrayList<StudentsGroup> studentsGroups;

    public Program(String name, Department department) {
        this.name = name;
        this.department = department;
        this.programID = count++;
        subjects = new ArrayList<>();
        studentsGroups = new ArrayList<>();
    }

    public int getProgramID() {
        return programID;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public ArrayList<Subject> getSubjects() {		
		return subjects;
	}

    public ArrayList<StudentsGroup> getStudentsGroups() {
        return studentsGroups;
    }

    public void addStudentGroups(ArrayList<StudentsGroup> groups) {
        for (int i = 0; i < groups.size(); i++) {
           studentsGroups.add(groups.get(i));
        }
	}

    
    public void addStudentGroup(StudentsGroup studentsGroup) {
        this.studentsGroups.add(studentsGroup);
	}
}
