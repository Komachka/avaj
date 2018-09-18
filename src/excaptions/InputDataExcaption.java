package src.excaptions;

public class InputDataExcaption extends Exception {

    public InputDataExcaption(String message, Throwable cause)
    {
        super(message, cause);
    }

    public InputDataExcaption(String message) {
        super(message);
    }
}