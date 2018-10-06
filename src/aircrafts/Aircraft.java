package src.aircrafts;

import src.lunch.Writter;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    static private long idCounter;

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId();

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public long getIdCounted() {
        return idCounter;
    }

    private long nextId()
    {
        return ++idCounter;
    }

    protected boolean isAircraftReachsZero()
    {
        if (coordinates.getHeight() <= 0) {
            printMessage("landing.");
            return true;
        }
        else
            return false;
    }


    protected void printMessage(String message)
    {
        Writter.printLine(getClass().getSimpleName()+"#"+name+": " + message);
    }

}
