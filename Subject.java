import java.util.ArrayList;

public class Subject 
{
    private int subjectID;
    private String name;
    private Program program;
    private boolean requiresLab;
    private String stat;
    private int semester;
    private ArrayList<Professor> adequateProfessors;
    private ArrayList<Professor> adequateAssistant;

    public Subject(int subjectID, String name, Program program, boolean requiresLab, String stat, int semester) 
    {
        this.subjectID = subjectID;
        this.name = name;
        this.program = program;
        this.requiresLab = requiresLab;
        this.stat = stat;
        this.semester = semester;
        adequateProfessors = new ArrayList<Professor>();
        adequateAssistant = new ArrayList<Professor>();
    }

    public int getID() {
        return subjectID;
    }

    public String getName() {
        return name;
    }

    public int getSemester() {
        return semester;
    }

    public Program getProgram() {
        return program;
    }

    public boolean isLabRequired() {
        return requiresLab;
    }

    public String getStat() {
        return stat;
    }

    public void addProfessors(ArrayList<Professor> professors) {
        for (int i = 0; i < professors.size(); i++) {
            if(professors.get(i).getTitle() == "Professor")
                adequateProfessors.add(professors.get(i));
            else
                adequateAssistant.add(professors.get(i));
        }
	}

    public void addProfessor(Professor professor) {
        if(professor.getTitle() == "Professor")
            adequateProfessors.add(professor);
        else
            adequateAssistant.add(professor);  
	}

	public ArrayList<Professor> getProfessors(boolean isExercise) {
        if(isExercise)
            return adequateAssistant;
        else
            return adequateProfessors;
	}

    public Professor getProfessor(int professorID) {
	
		for (Professor professor : adequateProfessors){
			if(professor.getID() == professorID) {
				return professor;
			}
		}
		return null;
	}

    public Professor getAssistant(int professorID) {
	
		for (Professor professor : adequateAssistant){
			if(professor.getID() == professorID) {
				return professor;
			}
		}
		return null;
	}
}
