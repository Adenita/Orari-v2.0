package model;

public class Professor 
{
    public int professorID;
    public String name;
    public String title;
    public int preferedStartTime;

    public Professor(int professorID, String name, String title, int preferedStartTime) {
        this.professorID = professorID;
        this.name = name;
        this.title = title;
        this.preferedStartTime = preferedStartTime;
    }

    public int getID() {
        return professorID;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return  title;
    }

    public int getPreferedStartTime() {
        return preferedStartTime;
    }
}