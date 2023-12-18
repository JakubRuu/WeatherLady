package pl.WL;

import pl.WL.openweatherapi.OpenWeatherApiService;

import java.util.Optional;

public class WeatherLadyApp {
    public static void main(String[] args) {

        OpenWeatherApiService openWeatherApiService = new OpenWeatherApiService();
        Optional<Weather> weather = openWeatherApiService.fetchByCityName("Jadeszki");
        weather.ifPresent(System.out::println);
    }
}
