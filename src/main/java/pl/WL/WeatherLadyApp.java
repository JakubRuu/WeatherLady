package pl.WL;

import pl.WL.openweatherapi.OpenWeatherApiService;
import pl.WL.Weatherapi.VisualWeatherApiService;
import pl.WL.weatherStackapi.WeatherStackApiService;

import java.util.Optional;

public class WeatherLadyApp {
    public static void main(String[] args) {
        WeatherLadyService weatherLadyService = new WeatherLadyService();
        Weather weather = weatherLadyService.fetchWeatherByCityName("Warszawa");
        Weather weather1 = weatherLadyService.fetchWeatherByCoordinates(35.0f,135.0f);
        System.out.println("Średnia: "+weather);
        System.out.println("Średnia: "+weather1);

    }
}
