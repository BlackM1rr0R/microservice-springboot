package com.example.weatherservice.service;

import com.example.weatherservice.entity.WeatherRepository;
import com.example.weatherservice.model.Weather;
import com.example.weatherservice.weatherdetailsservice.WeatherDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WeatherDetailsServiceImpl implements WeatherDetailsService {
    private final WeatherRepository weatherRepository;

    @Autowired
    public WeatherDetailsServiceImpl(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    @Override
    public List<Weather> getAllCity() {
        return weatherRepository.findAll();
    }

    @Override
    public Weather addCity(Weather weather) {
        return weatherRepository.save(weather);
    }

    @Override
    public Weather getCity(String cityname) {
        return weatherRepository.findByCityName(cityname);
    }

    @Override
    public Map<String, List<Weather>> getCityCategories() {
        Map<String, List<Weather>> cities = new HashMap<>();
        List<Weather> coldCities = weatherRepository.findByTemperatureBetween(1, 10);
        List<Weather> warmCities = weatherRepository.findByTemperatureBetween(10, 20);
        List<Weather> hotCities = weatherRepository.findByTemperatureBetween(20, 30);
        cities.put("Cold city", coldCities);
        cities.put("Warm city", warmCities);
        cities.put("Hot city", hotCities);
        return cities;
    }
}
