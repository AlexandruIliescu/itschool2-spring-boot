package ro.itschool.project.services;

import ro.itschool.project.models.dtos.WeatherResponseDTO;

import java.io.IOException;

public interface WeatherService {

    WeatherResponseDTO getCityWeather(String city) throws IOException;
}