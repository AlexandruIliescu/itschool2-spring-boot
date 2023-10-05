package ro.itschool.project.services;

import ro.itschool.project.models.WeatherResponse;

import java.io.IOException;

public interface WeatherService {

    WeatherResponse getCityWeather(String city) throws IOException;
}