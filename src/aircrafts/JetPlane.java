package src.aircrafts;


import src.excaptions.WeatherExcaptions;
import src.weather.WeatherTower;

public class JetPlane extends Aircaft implements Flyable {

    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() throws WeatherExcaptions {
        String tmpWeather = weatherTower.getWeather(coordinates);
        switch (tmpWeather)
        {
            case "SUN":
                coordinates.setLatitude(10);
                coordinates.setHeight(2);
                printMessage("SUNNY SUNNY SUNNY in da house!!!");
                break;
            case "RAIN":
                coordinates.setLatitude(5);
                printMessage("It's raining. Better watch out for lightings");
                break;
            case "FOG":
                coordinates.setLatitude(1);
                printMessage("OMG! THIS IS A FOOOOG!");
                break;
            case "SNOW":
                coordinates.setHeight(-7);
                printMessage("OMG! Winter is coming!");
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
