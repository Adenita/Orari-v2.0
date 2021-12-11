import java.util.ArrayList;
import java.util.stream.IntStream;

public class Population {

    private ArrayList<Schedule> schedules;

    public Population(int size, Data data) {
        schedules = new ArrayList<Schedule>(size);
        IntStream.range(0, size).forEach(x -> schedules.add(new Schedule(data).initialize()));
    }

    public ArrayList<Schedule> getSchedules() {
        return this.schedules;
    }

    public Population sortByFitness() {
        schedules.sort((schedule1, schedule2) -> {
            int val = 0;
            if (schedule1.getFitness() > schedule2.getFitness()) {
                val = -1;
            } else if (schedule1.getFitness() < schedule2.getFitness()) {
                val = 1;
            }
            return val;
        });
        return this;
    }
}