package ro.itschool.project.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ro.itschool.project.models.dtos.WeatherResponseDTO;
import ro.itschool.project.services.WeatherService;

import java.io.IOException;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/api/weather")
    public ResponseEntity<WeatherResponseDTO> getWeather(@RequestParam String city) throws IOException {
        //city name
        //current weather description
        //last time the weather information was updated

        // .../api/weather?city=London
        return ResponseEntity.ok(weatherService.getCityWeather(city));
    }
}