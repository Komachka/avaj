package src.weather;

import src.aircrafts.Aircraft;
import src.aircrafts.Flyable;
import src.excaptions.WeatherExcaptions;
import src.lunch.Writter;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    private List<Flyable> observers;

    public Tower() {
        observers = new ArrayList<>();
    }

    public int getCountObservers() {
        return observers.size();
    }

    public void register(Flyable flyable)
    {
        observers.add(flyable);
        Aircraft Aircraft = (Aircraft) flyable;
        Writter.printLine("Tower says: " +flyable.getClass().getSimpleName() +"#"+Aircraft.getName() +"("+Aircraft.getId()+")"+" registered to weather tower.");

    };

    public void unregister(Flyable flyable)
    {
        observers.remove(flyable);
        Aircraft Aircraft = (Aircraft) flyable;
        Writter.printLine("Tower says: " + flyable.getClass().getSimpleName() + "#" + Aircraft.getName() + " unregistered from weather tower.");
    };



    protected void conditionsChanged() throws WeatherExcaptions {

        for (int i = 0; i <observers.size() ; i++) {
            observers.get(i).updateConditions();
        }
    };





}
