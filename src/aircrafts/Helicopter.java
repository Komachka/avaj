package src.aircrafts;


import src.excaptions.WeatherExcaptions;
import src.weather.WeatherTower;

public class Helicopter extends Aircraft implements Flyable{
    private WeatherTower weatherTower;
    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() throws WeatherExcaptions {
        String tmpWeather = weatherTower.getWeather(coordinates);
        switch (tmpWeather)
        {
            case "SUN":
                coordinates.setLongitude(10);
                coordinates.setHeight(2);
                printMessage("This is hot.");
                break;
            case "RAIN":
                coordinates.setLongitude(5);
                printMessage("My rotor is going to rain!");
                break;
            case "FOG":
                coordinates.setLongitude(1);
                printMessage("My rotor is going to fog!");
                break;
            case "SNOW":
                coordinates.setHeight(-12);
                printMessage("My rotor is going to freeze!");
                break;
            default:
                throw new WeatherExcaptions("Weather is not correct");

        }
        if(isAircraftReachsZero())
            weatherTower.unregister(this);
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }
}
