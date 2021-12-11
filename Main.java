import java.util.ArrayList;

public class Main 
{
    public static final int populationSize = 100;
    public static final double mutationRate = 0.1;
    public static final double crossoverRate = 0.9;
    public static final int selectionSize = 3;
    public static final int eliteScedule = 1;   
    private int classNum = 1;
    private Data data;

    public static void main(String[] args) {
        Main main = new Main();
        main.data = new Data();
        int generation = 0;
        System.out.println("|Fitnes|Conficts|");
        GeneticAlgorithm ga = new GeneticAlgorithm(main.data);
        Population pop = new Population(Main.populationSize, main.data).sortByFitness();
        pop.getSchedules().forEach(schedule -> System.out.println("| " + String.format("%.5f", schedule.getFitness()) + " | " + schedule.getNumOfConf()));

        main.printScheduleAsTable(pop.getSchedules().get(0), generation);
        main.classNum = 1;
        while(pop.getSchedules().get(0).getFitness() != 1)
        {
           System.out.println("> Generation # " + ++generation);
           System.out.println("|Fitnes|Conficts|");
            pop = ga.evolve(pop).sortByFitness();
            pop.getSchedules().forEach(schedule -> System.out.println("| " + String.format("%.5f", schedule.getFitness()) + " | " + schedule.getNumOfConf()));  //System.out.println("        " + main.scheduleNum++ + "  | " + schedule + ));
            main.printScheduleAsTable(pop.getSchedules().get(0), generation);
            main.classNum = 1;
        }

    }

    private void printScheduleAsTable(Schedule schedule, int generation) 
    {
        ArrayList<Event> events = schedule.getEvents();
        System.out.print("\n            ");
        System.out.println("Event # | Program |              Subject                 |  ClassRoom   | Student Group |  Professor      |    Lecture time   |");
        System.out.print("                        ");
        System.out.print("--------------------------------------------------");
        System.out.println("---------------------------------------------------------------");
        events.forEach(x -> {
            int majorIndex = data.getPrograms().indexOf(x.getSubject().getProgram());
            int subjectIndex = data.getSubjects().indexOf(x.getSubject());
            int roomIndex = data.getAllClassrooms().indexOf(x.getClassroom());
            int professorIndex = data.getProfessors().indexOf(x.getProfessor());
            int lectureTimeIndex = data.getLectureTimes().indexOf(x.getLectureTime());
            int studentsGroupIndex = data.getAllStudentsGroups().indexOf(x.getGroup());
            System.out.print("                ");;
            System.out.print(String.format(" %1$02d", classNum) + "   | ");
            System.out.print(String.format("%1$4s", data.getPrograms().get(majorIndex).getName()) + " | ");
            System.out.print(String.format("%1$40s", data.getSubjects().get(subjectIndex).getName() + " (" + data.getSubjects().get(subjectIndex).getStat() + ")    | "));
            System.out.print(String.format("%1$12s", data.getAllClassrooms().get(roomIndex).getName() + " (" + x.getClassroom().getNumberOfSeats()) + ") | ");
            System.out.print(String.format("%1$10s", data.getAllStudentsGroups().get(studentsGroupIndex).getName() + " (" + data.getAllStudentsGroups().get(studentsGroupIndex).getNumberOfStudents()) + ")  |  ");
            System.out.print(String.format("%1$18s", data.getProfessors().get(professorIndex).getName() + " |  "));
            System.out.println(data.getLectureTimes().get(lectureTimeIndex).getDay() + " " + data.getLectureTimes().get(lectureTimeIndex). getTime());
            classNum++;

        });

        if(schedule.getFitness() == 1) {
            System.out.println("> solution found in " + (generation + 1) + " generations");
        }
        
        System.out.print("---------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------");

    }
}

