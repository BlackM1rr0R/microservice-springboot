package com.example.weatherservice.controller;

import com.example.weatherservice.model.Weather;
import com.example.weatherservice.weatherdetailsservice.WeatherDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
}
