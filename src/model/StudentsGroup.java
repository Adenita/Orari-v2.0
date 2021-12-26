package model;

import java.util.ArrayList;

public class StudentsGroup 
{
    private int groupID;
    private String name;
    private int numberOfStudents;
    private Program program;
    private boolean isExercise;
    private ArrayList<Subject> subjects;

    public StudentsGroup (int groupID, String name, int numberOfStudents, Program program, boolean isExercise) 
    {
        this.groupID = groupID;
        this.name = name;
        this.numberOfStudents = numberOfStudents;
        this.program = program;
        this.isExercise = isExercise;

        this.subjects = new ArrayList<Subject>();
    }

    public Program getProgram() {
        return program;
    }

    public boolean getIsExercise() {
        return isExercise;
    }

    public int getID() {
        return groupID;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public Subject getSubject(String subjectName) {
        for (Subject subject : subjects) {
            if(subject.getName().equals(subjectName))
                return subject;
        }
        return null;
    }

}
