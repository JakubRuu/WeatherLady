package pl.WL.openweatherapi;

import pl.WL.BaseFetchWeatherByCityName;

public class FetchWeatherByCityName extends BaseFetchWeatherByCityName<OpenWeather> {

    public FetchWeatherByCityName(String cityName) {
        super(cityName);
    }

    @Override
    public String getUrl() {
        return Config.getInstance().getFetchByCityNameQuery(cityName);
    }

    @Override
    public Class<OpenWeather> getClasz() {
        return OpenWeather.class;
    }
}
