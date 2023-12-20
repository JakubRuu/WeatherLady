package pl.WL;


public class WeatherLadyApp {
    public static void main(String[] args) {
        WeatherLadyService weatherLadyService = new WeatherLadyService();
        Weather weather = weatherLadyService.fetchWeatherByCityName("Warszawa");
        System.out.println("\n");
        
        Weather weather1 = weatherLadyService.fetchWeatherByCoordinates(52.2597f,21.012f);

        System.out.println("Średnia: "+weather);
        System.out.println("Średnia: "+weather1);

    }
}
