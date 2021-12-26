package geneticAlgorithm;

import java.util.stream.IntStream;
import java.util.ArrayList;

public class GeneticAlgorithm 
{
    private Data data;

    public static final int populationSize = 100;
    public static final double mutationRate = 0.1;
    public static final double crossoverRate = 0.9;
    public static final int selectionSize = 5;
    public static final int eliteScedule = 1; 

    public GeneticAlgorithm(Data data){
        this.data = data;
    }

    public Population evolve(Population population) {
        return mutatePopulation(crossoverPopulation(population));
    }

    Population crossoverPopulation(Population population){
        Population crossOverPopulation = new Population(population.getSchedules().size(), data);
        IntStream.range(0, eliteScedule).forEach(x -> crossOverPopulation.getSchedules().set(x, population.getSchedules().get(x)));
    
        IntStream.range(eliteScedule, population.getSchedules().size()).forEach(x -> {
            if(crossoverRate > Math.random()) {
                Schedule schedule1 = selectPopulation(population).sortByFitness().getSchedules().get(0);
                Schedule schedule2 = selectPopulation(population).sortByFitness().getSchedules().get(0);
                crossOverPopulation.getSchedules().set(x, crossoverSchedule(schedule1, schedule2));
            } else {
                crossOverPopulation.getSchedules().set(x, population.getSchedules().get(x));
            }
        });
        return crossOverPopulation;
    }

    Schedule crossoverSchedule(Schedule schedule1, Schedule schedule2) {
        Schedule crossOverSchedule = schedule1;
        for (int i = 0; i < schedule1.getEvents().size(); i++) {
            if(schedule1.getEvents().get(i).conflict())
                crossOverSchedule.getEvents().set(i, schedule2.getEvents().get(i));
          
        }
        return crossOverSchedule;
    }

    Population mutatePopulation(Population population){
        Population mutatePopulation = new Population(population.getSchedules().size(), data);
        ArrayList<Schedule> schedules = mutatePopulation.getSchedules();
        IntStream.range(0, eliteScedule).forEach(x -> schedules.set(x, population.getSchedules().get(x)));


        return mutatePopulation;
    }

    Schedule mutateSchedule(Schedule mutateSchedule) {
        Schedule schedule = new Schedule(data).initialize();
        IntStream.range(0, mutateSchedule.getEvents().size()).forEach(x -> {
            if(mutationRate > Math.random()) {
                mutateSchedule.getEvents().set(x, schedule.getEvents().get(x));
            }
        });

        return mutateSchedule;
    }

    Population selectPopulation(Population population) {
        Population selectPopulation = new Population(selectionSize, data);
        IntStream.range(0, selectionSize).forEach(x ->
            selectPopulation.getSchedules().set(x, population.getSchedules().get((int) (Math.random() * population.getSchedules().size()))));
        return selectPopulation;
    }
}
