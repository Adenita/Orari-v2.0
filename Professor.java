public class Professor 
{
    private int professorID;
    private String name;
    private String title;

    public Professor(int professorID, String name, String title) {
        this.professorID = professorID;
        this.name = name;
        this.title = title;
    }

    public int getID() {
        return professorID;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }
}