package pl.WL.Weatherapi;

public class Config {
    private static Config config;

    private final String baseApiUrl;
    private final String appId;


    public Config(String baseApiUrl, String appId) {
        this.baseApiUrl = baseApiUrl;
        this.appId = appId;

    }

    static Config getInstance() {
        if (config == null) {
            config = new Config("http://api.weatherapi.com/v1/current.json?key", "322b0368f4f24611b56140406231912");
        }
        return config;
    }

    String getFetchCityNameQuery(String cityName) {
        return String.format("%s=%s&q=%s&aqi=no", baseApiUrl, appId, cityName);
    }
}
// http://api.weatherapi.com/v1/current.json?key=322b0368f4f24611b56140406231912&q=Warszawa&aqi=no