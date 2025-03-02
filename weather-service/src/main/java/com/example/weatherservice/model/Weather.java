package com.example.weatherservice.model;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "weather")
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Column(unique = true, nullable = false)
    @NotNull(message = "City name cannot be null")
    @Size(min = 3, max = 50, message = "City name must be between 3 and 50 characters")
    private String cityName;

    @Min(value = -100, message = "Temperature must be greater than -100")
    @Max(value = 100, message = "Temperature must be less than 100")
    private double temperature;

    @Size(max = 200, message = "Description cannot be longer than 200 characters")
    private String description;

    @Column(nullable = false)
    private LocalDate date;
}
