package ro.itschool.project.models.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponseDTO {

    private String city;
    private String description;
    private LocalDateTime lastUpdated;
}