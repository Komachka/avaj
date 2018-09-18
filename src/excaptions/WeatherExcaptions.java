package src.excaptions;

public class WeatherExcaptions extends Exception {

    public WeatherExcaptions(String message, Throwable cause)
    {
        super(message, cause);
    }

    public WeatherExcaptions(String message) {
        super(message);
    }
}
