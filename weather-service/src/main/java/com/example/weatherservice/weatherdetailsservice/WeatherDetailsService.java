package com.example.weatherservice.weatherdetailsservice;

import com.example.weatherservice.model.Weather;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface WeatherDetailsService {
    List<Weather> getAllCity();
    Weather addCity(Weather weather);
    Optional<Weather> getCity(String cityname);
    Map<String, List<Weather>> getCityCategories();
    List<Weather> getWeatherByDateRange(LocalDate start, LocalDate end);
}
