package pl.WL.openweatherapi;

import pl.WL.Weather;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

class WeatherTransformer {
    static Weather toWeather(OpenWeather openWeather) {
        Weather weather = new Weather();
        weather.setCityName(openWeather.getName());
        weather.setTemp(openWeather.getWeatherDetails().getTemp());
        weather.setHumidity((int) openWeather.getWeatherDetails().getHumidity());
        weather.setPressure(openWeather.getWeatherDetails().getPressure());
        weather.setWindSpeed(openWeather.getWindDetails().getSpeed());
        weather.setWindDeg(openWeather.getWindDetails().getDeg());
        weather.setDataTime(LocalDateTime.ofEpochSecond(openWeather.getDateTime(), 0, ZoneOffset.UTC));
        return weather;
    }

}
