package com.example.weatherservice.weatherdetailsservice;

import com.example.weatherservice.model.Weather;

import java.util.List;

public interface WeatherDetailsService {
    List<Weather> getAllCity();
    Weather addCity(Weather weather);
}
