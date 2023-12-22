package pl.WL;

import org.h2.tools.Server;
import pl.WL.Weatherapi.VisualWeatherApiService;
import pl.WL.openweatherapi.OpenWeatherApiService;
import pl.WL.weatherStackapi.WeatherStackApiService;

import java.sql.Array;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;


public class WeatherLadyApp {
    public static void main(String[] args) {
        turnH2Server();
        List<WeatherApiService>weatherApiServices= Arrays.asList(new OpenWeatherApiService(),new WeatherStackApiService(), new VisualWeatherApiService());
        WeatherLadyRepository weatherLadyRepository = new WeatherLadyRepository();
        WeatherLadyService weatherLadyService = new WeatherLadyService(weatherApiServices, weatherLadyRepository);
        Weather weather = weatherLadyService.fetchWeatherByCityName("Warszawa");
        Weather weather1 = weatherLadyService.fetchWeatherByCoordinates(52.2597f, 21.012f);

    System.out.println(weather);
         System.out.println(weather1);

    }

    public static void turnH2Server() {
        Server server;
        try {
            server = Server.createWebServer();
            server.start();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

