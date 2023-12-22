package pl.WL.openweatherapi;

import pl.WL.BaseFetchWeatherByCoordianates;

class FetchWeatherByCoordinates extends BaseFetchWeatherByCoordianates<OpenWeather> {

    public FetchWeatherByCoordinates(float lat, float lon) {
        super(lat, lon);
    }

    @Override
    public String getUrl() {
        return Config.getInstance().getFetchByCoordinatesQuery(lat, lon);
    }

    @Override
    public Class<OpenWeather> getClasz() {
        return OpenWeather.class;
    }
}
