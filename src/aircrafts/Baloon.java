package src.aircrafts;


import src.excaptions.WeatherExcaptions;
import src.lunch.Writter;
import src.weather.WeatherTower;

public class Baloon extends Aircaft implements Flyable {

    private WeatherTower weatherTower;
    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() throws WeatherExcaptions {
        String tmpWeather = weatherTower.getWeather(coordinates);
        switch (tmpWeather)
        {
            case "SUN":
                coordinates.setLongitude(2);
                coordinates.setHeight(4);
                printMessage("Let's enjoy the good weather and take some pics.");
                break;
            case "RAIN":
                coordinates.setHeight(-5);
                printMessage("Damn you rain! You messed up my baloon.");
                break;
            case "FOG":
                coordinates.setHeight(-3);
                printMessage("It's fog. What is it?");
                break;
            case "SNOW":
                coordinates.setHeight(-15);
                printMessage("It's snowing. We're gonna crash.");
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
