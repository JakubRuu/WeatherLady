package pl.WL;


public abstract class BaseFetchWeatherByCoordianates<T> {
    protected final float lat;
    protected final float lon;
    private final HttpClientWrapper httpClientWrapper = new HttpClientWrapper();

    public BaseFetchWeatherByCoordianates(float lat, float lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public final T execute() {
        return HttpClientWrapperProvider.geInstance().get(getUrl(), getClasz());
    }

    public abstract String getUrl();

    public abstract Class<T> getClasz();
}
