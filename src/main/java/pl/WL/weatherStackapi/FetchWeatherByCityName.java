package pl.WL.weatherStackapi;

import com.google.gson.Gson;
import pl.WL.BaseFetchWeatherByCityName;
import pl.WL.NetworkApiException;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

class FetchWeatherByCityName extends BaseFetchWeatherByCityName<WeatherStack> {

     FetchWeatherByCityName(String cityName) {
        super(cityName);
    }
    @Override
    public String getUrl() {
        return Config.getInstance().getFetchCityNameQuery(cityName);
    }

    @Override
    public Class<WeatherStack> getClasz() {
        return WeatherStack.class;
    }
}
