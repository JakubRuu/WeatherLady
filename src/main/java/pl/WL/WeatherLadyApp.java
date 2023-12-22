package pl.WL;

import org.h2.tools.Server;

import java.sql.SQLException;


public class WeatherLadyApp {
    public static void main(String[] args) {
        turnH2Server();
        WeatherLadyRepository weatherLadyRepository = new WeatherLadyRepository();
        WeatherLadyService weatherLadyService = new WeatherLadyService(weatherLadyRepository);
        Weather weather = weatherLadyService.fetchWeatherByCityName("Warszawa");
        Weather weather1 = weatherLadyService.fetchWeatherByCoordinates(52.2597f, 21.012f);

        // System.out.println(weather);
        //  System.out.println(weather1);

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

