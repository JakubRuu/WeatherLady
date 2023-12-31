package pl.WL;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientWrapper {

    private final Gson gson = new Gson();
    private final HttpClient httpClient = HttpClient.newHttpClient();

    public final <T> T get(String url, Class<T> clasz) {
        try {
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .GET()
                    .build();
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(response.body(), clasz);
        } catch (IOException | InterruptedException | URISyntaxException e) {
            throw new NetworkApiException(e.getMessage());
        }
    }
}
