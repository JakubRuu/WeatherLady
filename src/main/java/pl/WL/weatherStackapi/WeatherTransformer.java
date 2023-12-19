package pl.WL.weatherStackapi;

import pl.WL.Weather;

class WeatherTransformer {
     static Weather toWeather(WeatherStack weatherStack) {
        Weather weather = new Weather();
        weather.setCityName(weatherStack.getLocation().getName());
        weather.setTemp(weatherStack.getWeatherDetails().getTemperature());
        weather.setHumidity(weatherStack.getWeatherDetails().getHumidity());
        weather.setPressure(weatherStack.getWeatherDetails().getPressure());
        weather.setWindSpeed(weatherStack.getWeatherDetails().getWindSpeed());
        weather.setWindDeg(weatherStack.getWeatherDetails().getWindDegree());
        return weather;
    }

}
