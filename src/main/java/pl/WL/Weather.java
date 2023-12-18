package pl.WL;

public class Weather {
    private String cityName;
    private float temp, pressure;
    private int humidity;
    private float windSpeed;
    private int windDeg;

    public Weather(String cityName, float temp, float pressure, int humidity, float windSpeed, int wimdDeg) {
        this.cityName = cityName;
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.windDeg = wimdDeg;

    }

    public Weather(float windSpeed, int wimdDeg) {

        this.windSpeed = windSpeed;
        this.windDeg = wimdDeg;
    }

    public Weather() {

    }

    public Weather(String cityName, float windSpeed, int wimdDeg) {
        this.cityName = cityName;
        this.windSpeed = windSpeed;
        this.windDeg = wimdDeg;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getWindDeg() {
        return windDeg;
    }

    public void setWindDeg(int windDeg) {
        this.windDeg = windDeg;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "cityName='" + cityName + '\'' +
                ", temp=" + temp +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", windSpeed=" + windSpeed +
                ", windDeg=" + windDeg +
                '}';
    }
}
