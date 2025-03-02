package com.example.weatherservice.service;

import com.example.weatherservice.entity.WeatherRepository;
import com.example.weatherservice.model.Weather;
import com.example.weatherservice.weatherdetailsservice.WeatherDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public Optional<Weather> getCity(String cityname) {
        return weatherRepository.findByCityName(cityname);
    }

    @Override
    public Map<String, List<Weather>> getCityCategories() {
        Map<String, List<Weather>> cities = new HashMap<>();
        cities.put("Cold city", weatherRepository.findByTemperatureBetween(1, 10));
        cities.put("Warm city", weatherRepository.findByTemperatureBetween(10, 20));
        cities.put("Hot city", weatherRepository.findByTemperatureBetween(20, 30));
        return cities;
    }

    @Override
    public List<Weather> getWeatherByDateRange(LocalDate start, LocalDate end) {
        return weatherRepository.findByDateBetween(start, end);
    }
}
