package com.example.weatherservice.controller;

import com.example.weatherservice.model.Weather;
import com.example.weatherservice.weatherdetailsservice.WeatherDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherDetailsService weatherDetailsService;

    @Autowired
    public WeatherController(WeatherDetailsService weatherDetailsService) {
        this.weatherDetailsService = weatherDetailsService;
    }

    @GetMapping("/allcity")
    public List<Weather> getAllCity() {
        return weatherDetailsService.getAllCity();
    }

    @PostMapping("/add-city")
    public Weather addCity(@RequestBody @Valid Weather weather) {
        return weatherDetailsService.addCity(weather);
    }

    @GetMapping("/{cityname}")
    public ResponseEntity<Optional<Weather>> getCity(@PathVariable String cityname) {
        Optional<Optional<Weather>> weather = Optional.ofNullable(weatherDetailsService.getCity(cityname));
        return weather.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @GetMapping("/city-categories")
    public Map<String, List<Weather>> getCityCategories() {
        return weatherDetailsService.getCityCategories();
    }

    @GetMapping("/dates-temperature")
    public List<Weather> getWeatherByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end
    ) {
        return weatherDetailsService.getWeatherByDateRange(start, end);
    }
}
