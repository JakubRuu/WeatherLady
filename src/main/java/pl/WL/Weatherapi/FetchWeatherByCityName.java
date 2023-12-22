package pl.WL.Weatherapi;

import pl.WL.BaseFetchWeatherByCityName;

public class FetchWeatherByCityName extends BaseFetchWeatherByCityName<WeatherVisual> {
    public FetchWeatherByCityName(String cityName) {
        super(cityName);
    }

    @Override
    public String getUrl() {
        return Config.getInstance().getFetchCityNameQuery(cityName);
    }

    @Override
    public Class<WeatherVisual> getClasz() {
        return WeatherVisual.class;
    }
}
