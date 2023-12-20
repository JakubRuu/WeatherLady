package pl.WL.weatherStackapi;

 class Config {
    private static Config config;
    private final String baseApiUrl;
    private final String appId;

    private Config(String baseApiUrl, String appId) {
        this.baseApiUrl = baseApiUrl;
        this.appId = appId;
    }
     // http://api.weatherstack.com/current?access_key=21905c30f7909d26e1c5f9d535320b6c&query=Warszawa
    String getFetchCityNameQuery(String cityName){
        return String.format("%s?access_key=%s&query=%s", baseApiUrl,appId,cityName);
    }
     String getFetchByCoordinatesQuery(float lat, float lon) {
         return String.format("%s?access_key=%s&query=%f,%f", baseApiUrl, appId, lat, lon);
     }
//http://api.weatherstack.com/current?access_key=21905c30f7909d26e1c5f9d535320b6c&query=52.250,21.000
//http://api.weatherstack.com/current?access_key=21905c30f7909d26e1c5f9d535320b6c&query=52.250,21.000

    static Config getInstance(){
        if (config==null){
            config=new Config("http://api.weatherstack.com/current","21905c30f7909d26e1c5f9d535320b6c");
        }
        return config;
    }
}
