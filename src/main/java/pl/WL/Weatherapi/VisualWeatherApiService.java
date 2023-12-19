package pl.WL.Weatherapi;

import pl.WL.NetworkApiException;
import pl.WL.Weather;

import java.util.Optional;

public class VisualWeatherApiService {
    public Optional<Weather> fetchByCityName(String cityName) {

        try {
            WeatherVisual weatherStack = new FetchWeatherByCityName(cityName).execute();
            return Optional.of(WeatherTransformer.toWeather(weatherStack));
        } catch (NetworkApiException e) {
            return Optional.empty();
        }
    }
}
