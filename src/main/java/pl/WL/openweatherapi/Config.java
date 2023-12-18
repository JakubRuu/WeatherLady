package pl.WL.openweatherapi;

 class Config {
    private static Config config;
    private final String baseApiUrl;
    private final String appId;

    private Config(String baseApiUrl, String appId) {
        this.baseApiUrl = baseApiUrl;
        this.appId = appId;
    }

     String getFetchByCityNameQuery(String cityName) {
        return String.format("%s?q=%s&appId=%s&units=metric", baseApiUrl, cityName, appId);

    }

     static Config getInstance() {
        if (config == null) {
            config = new Config("https://api.openweathermap.org/data/2.5/weather", "8b20f13a7b0d169fc6323de6cb9b338e");
        }
        return config;
    }
}
