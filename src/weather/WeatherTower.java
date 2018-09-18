package src.weather;

import src.aircrafts.Coordinates;
import src.excaptions.WeatherExcaptions;

public class WeatherTower extends Tower {


    public String getWeather(Coordinates coordinates)
    {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);

    };

    private void changeWeather() throws WeatherExcaptions {
        conditionsChanged();
    };

    public void simulateWeatherChanges(int amoutn) throws WeatherExcaptions {
        for (int i = 0; i <amoutn ; i++) {
            changeWeather();
        }
    }
}
