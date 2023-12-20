package pl.WL;


public abstract class BaseFetchWeatherByCoordianates<T>{
    private final HttpClientWrapper httpClientWrapper= new HttpClientWrapper();
    protected final float lat;
    protected final float lon;

    public BaseFetchWeatherByCoordianates(float lat, float lon) {
        this.lat = lat;
        this.lon = lon;
    }
    public final T execute(){
        return httpClientWrapper.get(getUrl(), getClasz());
    }
    public abstract String getUrl();
    public abstract Class<T> getClasz();
}
