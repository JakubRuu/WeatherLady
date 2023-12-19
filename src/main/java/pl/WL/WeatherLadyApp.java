package pl.WL;

import pl.WL.openweatherapi.OpenWeatherApiService;
import pl.WL.Weatherapi.VisualWeatherApiService;
import pl.WL.weatherStackapi.WeatherStackApiService;

import java.util.Optional;

public class WeatherLadyApp {
    public static void main(String[] args) {
        WeatherLadyService weatherLadyService = new WeatherLadyService();
        Weather weather = weatherLadyService.fetchWeatherByCityName("Warszawa");
        System.out.println("Średnia: "+weather);

    }
}
