package pl.WL;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class WeatherLadyService {
    private final WeatherLadyRepository weatherLadyRepository;
    private final List<WeatherApiService> weatherApiServices;

    public WeatherLadyService(List<WeatherApiService> weatherApiService, WeatherLadyRepository weatherLadyRepository) {
        this.weatherLadyRepository = weatherLadyRepository;
        this.weatherApiServices = weatherApiService;
    }

    public Weather fetchWeatherByCityName(String cityName) {

        List<Optional<Weather>> weatherOptionals = weatherApiServices.stream()
                .map(weatherApiService -> weatherApiService.fetchByCityName(cityName))
                .collect(Collectors.toList());

        List<Weather> weathers = weatherOptionals.stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
        System.out.println(weathers);
        Weather weather = new Weather();
        weather.setCityName(cityName);
        weather.setTemp(getAverageTemperature(weathers));
        weather.setPressure(getAveragePressure(weathers));
        weather.setHumidity((int) getAverageHumidity(weathers));
        weather.setWindSpeed(getAverageWindSpeedy(weathers));
        weather.setWindDeg((int) getAverageWindDeg(weathers));
        weather.setDataTime(getAverageDataTime(weathers));
        weatherLadyRepository.save(weather);
        return weather;
    }

    public Weather fetchWeatherByCoordinates(float lat, float lon) {
        List<Optional<Weather>> weatherOptionals = weatherApiServices.stream()
                .map(weatherApiService -> weatherApiService.fetchByCoordinates(lat, lon))
                .collect(Collectors.toList());

        List<Weather> weathers = weatherOptionals.stream()
                .filter(w -> w.isPresent())
                .map(w -> w.get())
                .collect(Collectors.toList());
        System.out.println(weathers);
        Weather weather = new Weather();
        weather.setCityName(weathers.stream()
                .findFirst()
                .map(w -> w.getCityName()).orElse("unknown"));
        weather.setTemp(getAverageTemperature(weathers));
        weather.setPressure(getAveragePressure(weathers));
        weather.setHumidity((int) getAverageHumidity(weathers));
        weather.setWindSpeed(getAverageWindSpeedy(weathers));
        weather.setWindDeg((int) getAverageWindDeg(weathers));
        weather.setDataTime(getAverageDataTime(weathers));
        weatherLadyRepository.save(weather);
        return weather;
    }

    private float getAverageTemperature(List<Weather> weathers) {
        return (float) weathers.stream().mapToDouble(Weather::getTemp).average().orElse(0.0f);
    }

    private float getAveragePressure(List<Weather> weathers) {
        return (float) weathers.stream().mapToDouble(Weather::getPressure).average().orElse(0.0f);
    }

    private float getAverageHumidity(List<Weather> weathers) {
        return (float) weathers.stream().mapToInt(Weather::getHumidity).average().orElse(0.0f);
    }

    private float getAverageWindSpeedy(List<Weather> weathers) {
        return (float) weathers.stream().mapToDouble(Weather::getWindSpeed).average().orElse(0.0f);
    }

    private float getAverageWindDeg(List<Weather> weathers) {
        return (float) weathers.stream().mapToDouble(Weather::getWindDeg).average().orElse(0.0f);
    }

    private LocalDateTime getAverageDataTime(List<Weather> weathers) {
        long averageDataTime = (long) weathers.stream().mapToDouble(w -> w.getDataTime().toEpochSecond(ZoneOffset.UTC)).average().orElse(0);
        return LocalDateTime.ofEpochSecond(averageDataTime, 0, ZoneOffset.UTC);
    }


}
