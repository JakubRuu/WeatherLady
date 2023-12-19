package pl.WL;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public abstract class BaseFetchWeatherByCityName<T> {
    protected final String cityName;

    public BaseFetchWeatherByCityName(String cityName) {
        this.cityName = cityName;
    }
    public final T execute() {
        Gson gson = new Gson();
        HttpClient httpClient = HttpClient.newHttpClient();
        try {
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(getUrl()))
                    .GET()
                    .build();
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(response.body(), getClasz());

        } catch (IOException | InterruptedException | URISyntaxException e) {
            throw new NetworkApiException(e.getMessage());
        }
    }
    public abstract String getUrl();
    public abstract Class<T> getClasz();
}
