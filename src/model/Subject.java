package model;

import java.util.ArrayList;

public class Subject 
{
    public int subjectID;
    public String name;
    public Program programm;
    public String program;
    public boolean requiresLab;
    public String stat;
    public int semester;
    public int etcs;
    public ArrayList<Professor> adequateProfessors;
    public ArrayList<Professor> adequateAssistant;

    public Subject(int subjectID, String name, int etcs, String program, boolean requiresLab, String stat, int semester) 
    {
        this.subjectID = subjectID;
        this.name = name;
        this.program = program;
        this.requiresLab = requiresLab;
        this.stat = stat;
        this.semester = semester;
        this.etcs = etcs;
        adequateProfessors = new ArrayList<Professor>();
        adequateAssistant = new ArrayList<Professor>();
    }

    public int getID() {
        return subjectID;
    }

    public int getEtcs() {
        return etcs;
    }
    public String getName() {
        return name;
    }

    public int getSemester() {
        return semester;
    }

    public Program getProgram() {
        return programm;
    }

    public String getProgramN() {
        return program;
    }

    public boolean isLabRequired() {
        return requiresLab;
    }

    public void setProgram(Program programm) {
        this.programm = programm;
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
