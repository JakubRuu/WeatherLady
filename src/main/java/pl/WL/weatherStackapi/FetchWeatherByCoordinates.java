package pl.WL.weatherStackapi;

import pl.WL.BaseFetchWeatherByCoordianates;


class FetchWeatherByCoordinates extends BaseFetchWeatherByCoordianates<WeatherStack> {
    public FetchWeatherByCoordinates(float lat, float lon) {
        super(lat, lon);
    }

    @Override
    public String getUrl() {
        return Config.getInstance().getFetchByCoordinatesQuery(lat, lon);
    }

    @Override
    public Class<WeatherStack> getClasz() {
        return WeatherStack.class;
    }

}
