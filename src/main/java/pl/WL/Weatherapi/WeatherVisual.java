package pl.WL.Weatherapi;

import com.google.gson.annotations.SerializedName;

class WeatherVisual {
    private Location location;

    @SerializedName("current")
    private WeatherDetails weatherDetails;

    public WeatherVisual(Location location, WeatherDetails weatherDetails) {
        this.location = location;
        this.weatherDetails = weatherDetails;
    }

    public WeatherVisual(WeatherDetails weatherDetails) {
        this.weatherDetails = weatherDetails;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    WeatherDetails getWeatherDetails() {
        return weatherDetails;
    }

    void setWeatherDetails(WeatherDetails weatherDetails) {
        this.weatherDetails = weatherDetails;
    }

    @Override
    public String toString() {
        return "WeatherVisual{" +
                ", weatherDetails=" + weatherDetails +
                '}';
    }
}

class Location {
    private String name;


    Location() {
    }

    public Location(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                '}';
    }
}

class WeatherDetails {
    @SerializedName("temp_c")
    private float temp;
    private int humidity;
    @SerializedName("pressure_mb")
    private float pressure;
    @SerializedName("wind_kph")
    private float windSpeed;
    @SerializedName("wind_degree")
    private float windDegree;
    @SerializedName("last_updated_epoch")
    private long dateTime;


    public WeatherDetails(float temp, int humidity, float pressure, float windSpeed, float windDegree, long dateTime) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        this.windSpeed = windSpeed;
        this.windDegree = windDegree;
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "WeatherDetails{" +
                "temp=" + temp +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                ", windSpeed=" + windSpeed +
                ", windDegree=" + windDegree +
                ", dateTime=" + dateTime +
                '}';
    }

    public long getDateTime() {
        return dateTime;
    }

    public void setDateTime(long dateTime) {
        this.dateTime = dateTime;
    }

    float getTemp() {
        return temp;
    }

    void setTemp(float temp) {
        this.temp = temp;
    }

    int getHumidity() {
        return humidity;
    }

    void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    float getPressure() {
        return pressure;
    }

    void setPressure(float pressure) {
        this.pressure = pressure;
    }

    float getWindSpeed() {
        return windSpeed;
    }

    void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }

    float getWindDegree() {
        return windDegree;
    }

    void setWindDegree(float windDegree) {
        this.windDegree = windDegree;
    }
}