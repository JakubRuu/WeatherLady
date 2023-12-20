package pl.WL;

public class HttpClientWrapperProvider {
    private static HttpClientWrapper httpClientWrapper;
    public static HttpClientWrapper geInstance(){
        if (httpClientWrapper==null){
            httpClientWrapper=new HttpClientWrapper();
        }
        return httpClientWrapper;
    }
}
