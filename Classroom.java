public class Classroom 
{
     private  int classID = 0;
     private static int count;
     private String name;
     private boolean hasComputer;
     private int numberOfSeats;

     public Classroom(String name, int numberOfSeats, boolean hasComputer) {
        this.name = name;
        this.hasComputer = hasComputer;
        this.numberOfSeats = numberOfSeats;
        classID = count++;
    }

    public int getClassID() {
        return classID;
    }

    public String getName() {
        return name;
    }

    public boolean isLab() {
        return hasComputer;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }


}
