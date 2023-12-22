package pl.WL;


import java.util.Optional;

public interface WeatherApiService {

    public Optional<Weather> fetchByCityName(String cityName);

    public Optional<Weather> fetchByCoordinates(float lat, float lon);
}
