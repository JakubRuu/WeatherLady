package pl.WL.weatherStackapi;

import pl.WL.BaseFetchWeatherByCityName;

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
