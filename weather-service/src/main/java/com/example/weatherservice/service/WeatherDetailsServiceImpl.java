package com.example.weatherservice.service;

import com.example.weatherservice.entity.WeatherRepository;
import com.example.weatherservice.model.Weather;
import com.example.weatherservice.weatherdetailsservice.WeatherDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
