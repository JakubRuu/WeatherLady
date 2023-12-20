package pl.WL;

public abstract class BaseFetchWeatherByCityName<T> {
    private final HttpClientWrapper httpClientWrapper= new HttpClientWrapper();
    protected final String cityName;
    public BaseFetchWeatherByCityName(String cityName) {
        this.cityName = cityName;
    }
    public final T execute() {
       return HttpClientWrapperProvider.geInstance().get(getUrl(),getClasz());
    }
    public abstract String getUrl();
    public abstract Class<T> getClasz();
}
