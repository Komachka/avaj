package src.aircrafts;


public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;
    static final int MAX = 100;
    static final int MIN = 0;


    public Coordinates(int longitude, int latitude, int height) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }

    public void setLongitude(int longitude) {
        if (this.longitude + longitude <= MAX)
        this.longitude += longitude;
    }

    public void setLatitude(int latitude) {
        if (this.latitude + latitude <= MAX)
            this.latitude += latitude;
    }

    public void setHeight(int height) {
        if (this.height + height <= MAX)
            this.height += height;
    }
}
