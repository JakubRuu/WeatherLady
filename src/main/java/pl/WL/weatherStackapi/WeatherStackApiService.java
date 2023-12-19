package pl.WL.weatherStackapi;

import pl.WL.NetworkApiException;
import pl.WL.Weather;


import java.util.Optional;
public class WeatherStackApiService {
    public Optional<Weather> fetchByCityName(String cityName) {

        try {
       WeatherStack weatherStack = new FetchWeatherByCityName (cityName).execute();
            return Optional.of(WeatherTransformer.toWeather(weatherStack));
        } catch (NetworkApiException e) {
            return Optional.empty();
        }
    }


}