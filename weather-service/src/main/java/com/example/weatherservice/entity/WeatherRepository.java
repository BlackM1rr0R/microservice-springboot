package com.example.weatherservice.entity;

import com.example.weatherservice.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {
    Weather findByCityName(String cityname);

    List<Weather> findByTemperatureBetween(int i, int i1);
}
