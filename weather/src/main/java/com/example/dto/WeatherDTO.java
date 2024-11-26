package com.example.dto;

import java.time.LocalDate;

public class WeatherDTO
{
    private LocalDate date;
    private String region;
    private String weather;
    private float temperature;

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

    @Override
    public String toString()
    {
        return "WeatherDTO{" +
                "date=" + date +
                ", region='" + region + '\'' +
                ", weather='" + weather + '\'' +
                ", temperature=" + temperature +
                '}';
    }
}
