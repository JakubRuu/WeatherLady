package pl.WL.openweatherapi;

import com.google.gson.Gson;
import pl.WL.NetworkApiException;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

class FetchWeatherByCityName {
    private final String cityName;

     FetchWeatherByCityName(String cityName) {
        this.cityName = cityName;
    }

     OpenWeather execute() {
        Gson gson = new Gson();
        HttpClient httpClient = HttpClient.newHttpClient();
        try {
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(Config.getInstance().getFetchByCityNameQuery(cityName)))
                    .GET()
                    .build();
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(response.body(), OpenWeather.class);

        } catch (IOException | InterruptedException | URISyntaxException e) {
            throw new NetworkApiException(e.getMessage());
        }
    }
}
