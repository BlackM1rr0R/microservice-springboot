package com.example.weatherservice.weatherdetailsservice;

import com.example.weatherservice.model.Weather;

import java.util.List;
import java.util.Map;

public interface WeatherDetailsService {
    List<Weather> getAllCity();
    Weather addCity(Weather weather);
    Weather getCity(String cityname);
    Map<String, List<Weather>> getCityCategories();
}
