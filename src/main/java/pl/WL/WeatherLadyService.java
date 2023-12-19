package pl.WL;

import pl.WL.Weatherapi.VisualWeatherApiService;
import pl.WL.openweatherapi.OpenWeatherApiService;
import pl.WL.weatherStackapi.WeatherStackApiService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class WeatherLadyService {
    public Weather fetchWeatherByCityName(String cityName){
        OpenWeatherApiService openWeatherApiService = new OpenWeatherApiService();
        WeatherStackApiService weatherStackApiService = new WeatherStackApiService();
        VisualWeatherApiService visualWeatherApiService=new VisualWeatherApiService();
        List<Optional<Weather>> weatherOptionals= new ArrayList<>();
        weatherOptionals.add(openWeatherApiService.fetchByCityName(cityName));
        weatherOptionals.add(weatherStackApiService.fetchByCityName(cityName));
        weatherOptionals.add(visualWeatherApiService.fetchByCityName(cityName));

        List<Weather> weathers=weatherOptionals.stream()
                .filter(w-> w.isPresent())
                .map(w-> w.get())
                .collect(Collectors.toList());
        System.out.println(weathers);
        Weather weather=new Weather();
        weather.setCityName(cityName);
        weather.setTemp(getAverageTemperature(weathers));
        weather.setPressure(getAveragePressure(weathers));
        weather.setHumidity((int)getAverageHumidity(weathers));
        weather.setWindSpeed(getAverageWindSpeedy(weathers));
        weather.setWindDeg((int)getAverageWindDeg(weathers));
        return weather;
    }
    public Weather fetchWeatherByCoordinates(float lat, float lon){
        OpenWeatherApiService openWeatherApiService = new OpenWeatherApiService();
        WeatherStackApiService weatherStackApiService = new WeatherStackApiService();
        VisualWeatherApiService visualWeatherApiService=new VisualWeatherApiService();
        List<Optional<Weather>> weatherOptionals= new ArrayList<>();
        weatherOptionals.add(openWeatherApiService.fetchByCoordinates(lat, lon));
        weatherOptionals.add(weatherStackApiService.fetchByCoordinates(lat, lon));
        //weatherOptionals.add(visualWeatherApiService.fetchByCoordinates(lat, lon));

        List<Weather> weathers=weatherOptionals.stream()
                .filter(w-> w.isPresent())
                .map(w-> w.get())
                .collect(Collectors.toList());
        System.out.println(weathers);
        Weather weather=new Weather();
        weather.setCityName(weathers.stream().findFirst().map( w-> w.getCityName()).orElse("unknown"));
        weather.setTemp(getAverageTemperature(weathers));
        weather.setPressure(getAveragePressure(weathers));
        weather.setHumidity((int)getAverageHumidity(weathers));
        weather.setWindSpeed(getAverageWindSpeedy(weathers));
        weather.setWindDeg((int)getAverageWindDeg(weathers));
        return weather;
    }
    private float getAverageTemperature(List<Weather>weathers){
        return (float) weathers.stream().mapToDouble(w-> w.getTemp()).average().orElse(0.0f);
    }
    private float getAveragePressure(List<Weather>weathers){
        return (float) weathers.stream().mapToDouble(w-> w.getPressure()).average().orElse(0.0f);
    }
    private float getAverageHumidity(List<Weather>weathers){
        return (float) weathers.stream().mapToInt(w-> w.getHumidity()).average().orElse(0.0f);
    }
    private float getAverageWindSpeedy(List<Weather>weathers){
        return (float) weathers.stream().mapToDouble(w-> w.getWindSpeed()).average().orElse(0.0f);
    }
    private float getAverageWindDeg(List<Weather>weathers){
        return (float) weathers.stream().mapToDouble(w-> w.getWindDeg()).average().orElse(0.0f);
    }


}
