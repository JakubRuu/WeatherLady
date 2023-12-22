package pl.WL;

public abstract class BaseFetchWeatherByCityName<T> {
    protected final String cityName;
    private final HttpClientWrapper httpClientWrapper = new HttpClientWrapper();

    public BaseFetchWeatherByCityName(String cityName) {
        this.cityName = cityName;
    }

    public final T execute() {
        return HttpClientWrapperProvider.geInstance().get(getUrl(), getClasz());
    }

    public abstract String getUrl();

    public abstract Class<T> getClasz();
}
