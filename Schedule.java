import java.util.ArrayList;

public class Schedule 
{
    private ArrayList<Event> events;
    private boolean fitChange = true;
    private double fitness = -1;
    private int numberOfConflicts = 0;
    private Data data;

    public Data getData() {
        return data;
    }

    public Schedule(Data data) {
        this.data = data;
        events = new ArrayList<Event>();
    }

    public Schedule initialize() {
            data.getPrograms().forEach(prog -> data.getSubjectsPerSemester(prog.getName(), 4).forEach(subject -> {
                data.getStudentGroupsPerProgram(subject.getName(), prog.getName()).forEach(group -> {
                    Event newEvent = new Event(subject);
                    newEvent.setLectureTime(data.getLectureTimes().get((int)(data.getLectureTimes().size() * Math.random())));
                    newEvent.setClassroom(data.getClassrooms(subject.isLabRequired() && group.getIsExercise()).get((int)(data.getClassrooms(subject.isLabRequired() && group.getIsExercise()).size() * Math.random())));
                    newEvent.setProfessor(data.getProfessorsPerSubject(subject, group.getIsExercise()).get((int)(data.getProfessorsPerSubject(subject, group.getIsExercise()).size() * Math.random())));
                    newEvent.setGroup(group);
                    events.add(newEvent);
                    
                });

            }));

        return this;
    }
    
    // shto edhe soft conditions p.sh. profa 1 preferon me i mbajt ligjeratat paradite
    public int getNumOfConf() {
        return numberOfConflicts;
    }

    public ArrayList<Event> getEvents() {
            fitChange = true;
            return events;
    }

    public double getFitness() {
        if (fitChange == true) {
            fitness = calcFitness();
            fitChange = false;
        }
        return fitness;
    }

    private double calcFitness() {
        numberOfConflicts = 0;
        events.forEach(x -> {
            if (x.getClassroom().getNumberOfSeats() < x.getGroup().getNumberOfStudents()) { numberOfConflicts++; 
                x.setConflict(true);
            }
            events.forEach(y -> { 
                if(y.getId() > x.getId()) { 
                if (x.getLectureTime().collision(y.getLectureTime())) {
                    if (x.getClassroom().getClassID() == (y.getClassroom().getClassID())) {
                     numberOfConflicts++;
                     y.setConflict(true);
                    }
                    if (x.getProfessor().getID() ==  y.getProfessor().getID()) {
                        numberOfConflicts++;
                        y.setConflict(true);
                    }   
                }
                }
            });
        });
        return 1/(double)(numberOfConflicts + 1);
    }

    public String toString() {
        String val = new String();
        for (int x = 0; x < events.size() - 1; x++) {
            val += events.get(x) + ",";
        }
        val += events.get(events.size() - 1);
        return val;
    }
}
