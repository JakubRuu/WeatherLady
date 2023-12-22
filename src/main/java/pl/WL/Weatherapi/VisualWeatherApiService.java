package pl.WL.Weatherapi;

import pl.WL.NetworkApiException;
import pl.WL.Weather;
import pl.WL.WeatherApiService;

import java.util.Optional;

public class VisualWeatherApiService implements WeatherApiService {
    @Override
    public Optional<Weather> fetchByCityName(String cityName) {

        try {
            WeatherVisual weatherVisual = new FetchWeatherByCityName(cityName).execute();
            return Optional.of(WeatherTransformer.toWeather(weatherVisual));
        } catch (NetworkApiException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Weather> fetchByCoordinates(float lat, float lon) {

        try {
            WeatherVisual weatherVisual = new FetchWeatherByCoordianates(lat, lon).execute();
            return Optional.of(WeatherTransformer.toWeather(weatherVisual));
        } catch (NetworkApiException e) {
            return Optional.empty();
        }
    }


}
