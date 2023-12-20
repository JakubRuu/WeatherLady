package pl.WL.Weatherapi;


import pl.WL.BaseFetchWeatherByCoordianates;


public class FetchWeatherByCoordianates extends BaseFetchWeatherByCoordianates<WeatherVisual> {
    public FetchWeatherByCoordianates(float lat, float lon) {
        super(lat, lon);
    }

    @Override
    public String getUrl() {
        return Config.getInstance().getFetchCoordianates(lat, lon);
    }

    @Override
    public Class<WeatherVisual> getClasz() {
        return WeatherVisual.class;
    }
}
