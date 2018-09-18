package src.weather;

import src.aircrafts.Aircaft;
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
        Aircaft aircaft = (Aircaft) flyable;
        Writter.printLine("Tower says: " +flyable.getClass().getSimpleName() +"#"+aircaft.getName() +"("+aircaft.getId()+")"+" registered to weather tower.");

    };

    public void unregister(Flyable flyable)
    {
        observers.remove(flyable);
        Aircaft aircaft = (Aircaft) flyable;
        Writter.printLine("Tower says: " + flyable.getClass().getSimpleName() + "#" + aircaft.getName() + " unregistered from weather tower.");
    };



    protected void conditionsChanged() throws WeatherExcaptions {
        
        for (int i = 0; i <observers.size() ; i++) {
            observers.get(i).updateConditions();
        }
    };





}
