package src.weather;

import src.aircrafts.Coordinates;

import java.util.Random;

public class WeatherProvider {
    private final static WeatherProvider weatherProvider = new WeatherProvider();
    private static final String [] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private int weatherINDEX;

    private WeatherProvider() {


    }


    public static WeatherProvider getProvider() {
        return weatherProvider;
    }
    public String getCurrentWeather(Coordinates coordinates)
    {
        weatherINDEX = new Random().nextInt(1111);
        return weather[(coordinates.getHeight()* weatherINDEX + coordinates.getLatitude() * weatherINDEX + coordinates.getHeight()*weatherINDEX)%weather.length];
    };

}
