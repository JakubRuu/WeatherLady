package pl.WL.openweatherapi;

import pl.WL.NetworkApiException;
import pl.WL.Weather;
import pl.WL.WeatherApiService;

import java.util.Optional;


public class OpenWeatherApiService implements WeatherApiService {
    @Override
    public Optional<Weather> fetchByCityName(String cityName) {

        try {
            OpenWeather openWeather = new FetchWeatherByCityName(cityName).execute();
            return Optional.of(WeatherTransformer.toWeather(openWeather));
        } catch (NetworkApiException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Weather> fetchByCoordinates(float lat, float lon) {

        try {
            OpenWeather openWeather = new FetchWeatherByCoordinates(lat, lon).execute();
            return Optional.of(WeatherTransformer.toWeather(openWeather));
        } catch (NetworkApiException e) {
            return Optional.empty();
        }
    }
}
