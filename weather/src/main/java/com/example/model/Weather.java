package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;


@Entity
@Table(name="WEATHER")
public class Weather
{
    // DB 테이블에는
    // (날짜, 지역)이 복합키로 지정되어 있습니다.
    @Id
    private LocalDate date;
    private String region;
    private String weather;
    private float temperature;

    public Weather()
    {}


    public Weather(LocalDate date, String region, String weather, float temperature)
    {
        this.date = date;
        this.region = region;
        this.weather = weather;
        this.temperature = temperature;
    }

    // Getters and Setters
    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }

    public String getRegion()
    {
        return region;
    }

    public void setRegion(String region)
    {
        this.region = region;
    }

    public String getWeather()
    {
        return weather;
    }

    public void setWeather(String weather)
    {
        this.weather = weather;
    }

    public float getTemperature()
    {
        return temperature;
    }

    public void setTemperature(float temperature)
    {
        this.temperature = temperature;
    }
}