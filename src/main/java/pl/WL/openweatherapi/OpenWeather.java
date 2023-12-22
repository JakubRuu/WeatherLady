package pl.WL.openweatherapi;

import com.google.gson.annotations.SerializedName;

class OpenWeather {
    private String name;
    @SerializedName("main")
    private WeatherDetails weatherDetails;
    @SerializedName("wind")
    private WindDetails windDetails;
    @SerializedName("dt")
    private long dateTime;


    public OpenWeather(String name, WeatherDetails weatherDetails, WindDetails windDetails, long dateTime) {
        this.name = name;
        this.weatherDetails = weatherDetails;
        this.windDetails = windDetails;
        this.dateTime = dateTime;
    }

    long getDateTime() {
        return dateTime;
    }

    void setDateTime(long dateTime) {
        this.dateTime = dateTime;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    WeatherDetails getWeatherDetails() {
        return weatherDetails;
    }

    void setWeatherDetails(WeatherDetails weatherDetails) {
        this.weatherDetails = weatherDetails;
    }

    WindDetails getWindDetails() {
        return windDetails;
    }

    void setWindDetails(WindDetails windDetails) {
        this.windDetails = windDetails;
    }

    @Override
    public String toString() {
        return "OpenWeather{" +
                "name='" + name + '\'' +
                ", weatherDetails=" + weatherDetails +
                ", windDetails=" + windDetails +
                ", dateTime=" + dateTime +
                '}';
    }
}

class WeatherDetails {
    private float temp;
    private float pressure;
    private float humidity;

    WeatherDetails() {
    }

    WeatherDetails(float temp, float pressure, float humidity) {
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    float getHumidity() {
        return humidity;
    }

    void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    float getTemp() {
        return temp;
    }

    void setTemp(float temp) {
        this.temp = temp;
    }

    float getPressure() {
        return pressure;
    }

    void setPressure(float pressure) {
        this.pressure = pressure;
    }

    @Override
    public String toString() {
        return "WeatherDetails{" +
                "temp=" + temp +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                '}';
    }
}

class WindDetails {
    private float speed;
    private int deg;

    WindDetails(float speed, int deg) {
        this.speed = speed;
        this.deg = deg;
    }

    WindDetails() {
    }

    int getDeg() {
        return deg;
    }

    void setDeg(int deg) {
        this.deg = deg;
    }

    float getSpeed() {
        return speed;
    }

    void setSpeed(float speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "WindDetails{" +
                "speed=" + speed +
                ", deg=" + deg +
                '}';
    }
}
