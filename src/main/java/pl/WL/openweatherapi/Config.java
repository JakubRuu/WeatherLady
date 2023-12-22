package pl.WL.openweatherapi;

public class Config {
    private static Config config;
    private final String baseApiUrl;
    private final String appId;

    private Config(String baseApiUrl, String appId) {
        this.baseApiUrl = baseApiUrl;
        this.appId = appId;
    }

    public static Config getInstance() {
        if (config == null) {
            config = new Config("https://api.openweathermap.org/data/2.5/weather", "8b20f13a7b0d169fc6323de6cb9b338e");
        }
        return config;
    }

    public String getFetchByCityNameQuery(String cityName) {
        return String.format("%s?q=%s&appId=%s&units=metric", baseApiUrl, cityName, appId);
    }

    String getFetchByCoordinatesQuery(float lat, float lon) {
        // https://api.openweathermap.org/data/2.5/weather?lat=52.23&lon=21.02&appid=8b20f13a7b0d169fc6323de6cb9b338e&units=metric
        return String.format("%s?lat=%f&lon=%f&appid=%s&units=metric", baseApiUrl, lat, lon, appId);
    }
}
