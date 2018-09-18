package src.aircrafts;

import src.excaptions.WeatherExcaptions;
import src.weather.WeatherTower;

public interface Flyable {

    public void updateConditions() throws WeatherExcaptions;
    public void registerTower(WeatherTower weatherTower);
}
