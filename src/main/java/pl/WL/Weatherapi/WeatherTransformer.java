package pl.WL.Weatherapi;

import pl.WL.Weather;

import java.time.LocalDateTime;
import java.time.ZoneOffset;


class WeatherTransformer {
    static Weather toWeather(WeatherVisual weatherVisual) {
        Weather weather = new Weather();
        weather.setCityName(weatherVisual.getLocation().getName());
        weather.setTemp(weatherVisual.getWeatherDetails().getTemp());
        weather.setHumidity(weatherVisual.getWeatherDetails().getHumidity());
        weather.setPressure(weatherVisual.getWeatherDetails().getPressure());
        weather.setWindSpeed(weatherVisual.getWeatherDetails().getWindSpeed());
        weather.setWindDeg((int) weatherVisual.getWeatherDetails().getWindDegree());
        weather.setDataTime(LocalDateTime.ofEpochSecond(weatherVisual.getWeatherDetails().getDateTime(), 0, ZoneOffset.UTC));
        return weather;
    }
}
