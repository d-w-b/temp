package com.example.service;

import com.example.dto.WeatherDTO;
import com.example.mapper.IModelMapper;
import com.example.mapper.WeatherMapper;
import com.example.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherService {

    private final WeatherMapper weatherMapper;
    private final IModelMapper modelMapper;


    @Autowired
    WeatherService(WeatherMapper weatherMapper, IModelMapper modelMapper)
    {
        this.weatherMapper = weatherMapper;
        this.modelMapper = modelMapper;
    }

    public List<WeatherDTO> findAll()
    {
        return weatherMapper.findAll()
                            .stream()
                            .map(entity -> modelMapper.map(entity, WeatherDTO.class))
                            .collect(Collectors.toList());
    }

    public WeatherDTO findByDateAndRegion(LocalDate date, String region)
    {
        Weather result = weatherMapper.findByDateAndRegion(date, region);
        if(result == null)
            return null;

        return modelMapper.map(result, WeatherDTO.class);
    }

    public boolean insertOne(WeatherDTO weather)
    {
        Weather existingWeather = weatherMapper.findByDateAndRegion(weather.getDate(), weather.getRegion());
        if(existingWeather != null)
        {
            // 추가할 대상이 이미 존재할 경우 처리할 작업
            return false;
        }

        Weather newWeather = modelMapper.map(weather, Weather.class);
        return weatherMapper.insertWeather(newWeather);
    }

    public boolean updateOne(WeatherDTO weather)
    {
        Weather updatedWeather = modelMapper.map(weather, Weather.class);
        return weatherMapper.updateWeather(updatedWeather);
    }

    public boolean deleteOne(LocalDate date, String region)
    {
        return weatherMapper.deleteWeather(date, region);
    }
}
