package pl.WL.weatherStackapi;

import com.google.gson.annotations.SerializedName;

class WeatherStack {
    private Location location;

    @SerializedName("current")
    private WeatherDetails weatherDetails;

    WeatherStack(Location location) {
        this.location = location;
    }

    WeatherStack(Location location, WeatherDetails weatherDetails) {
        this.location = location;
        this.weatherDetails = weatherDetails;
    }

    Location getLocation() {
        return location;
    }

    void setLocation(Location location) {
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
        return "WeatherStack{" +
                "location=" + location +
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
    private float temperature;
    private int humidity;
    private int pressure;
    @SerializedName("wind_speed")
    private float windSpeed;
    @SerializedName("wind_degree")
    private int windDegree;

    WeatherDetails(float temperature, int humidity, int pressure, float windSpeed, int windDegree) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.windSpeed = windSpeed;
        this.windDegree = windDegree;
    }

    WeatherDetails() {

    }

    WeatherDetails(float temperature) {
        this.temperature = temperature;
    }

    float getTemperature() {
        return temperature;
    }

    void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    int getHumidity() {
        return humidity;
    }

    void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    int getPressure() {
        return pressure;
    }

    void setPressure(int pressure) {
        this.pressure = pressure;
    }

    float getWindSpeed() {
        return windSpeed;
    }

    void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }

    int getWindDegree() {
        return windDegree;
    }

    void setWindDegree(int windDegree) {
        this.windDegree = windDegree;
    }

    @Override
    public String toString() {
        return "WeatherDetails{" +
                "temperature=" + temperature +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                ", windSpeed=" + windSpeed +
                ", windDegree=" + windDegree +
                '}';
    }
}
