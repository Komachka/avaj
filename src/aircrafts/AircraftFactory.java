package src.aircrafts;


import src.excaptions.WeatherExcaptions;

public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws WeatherExcaptions
    {
        switch (type.toLowerCase().trim())
        {
            case "baloon" :
                return new Baloon(name, new Coordinates(longitude, latitude, height));
            case "jetplane" :
                return new JetPlane(name, new Coordinates(longitude, latitude, height));
            case "helicopter" :
                return new Helicopter(name, new Coordinates(longitude, latitude, height));
            default:
                throw new WeatherExcaptions("There is incorect input type");
        }
    }

}
