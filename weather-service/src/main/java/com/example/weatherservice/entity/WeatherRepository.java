package com.example.weatherservice.entity;

import com.example.weatherservice.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {
    Optional<Weather> findByCityName(String cityname);
    List<Weather> findByTemperatureBetween(double min, double max);
    List<Weather> findByDateBetween(LocalDate start, LocalDate end);
}
